# Java ile Socket Tabanlı Basit Web Sunucusu

Bu proje, hiçbir üçüncü parti kütüphane ya da hazır HTTP sunucusu kullanmadan, yalnızca Java standart kütüphanesindeki `ServerSocket` ve `Socket` sınıfları ile yazılmış basit bir web sunucusudur. Sunucu **1989** numaralı portu dinler. Herhangi bir web tarayıcısı bağlandığında, biçimlendirilmiş bir öğrenci biyografisi sayfası döndürür.

## Proje Bilgileri

| | |
|---|---|
| **Ad Soyad** | Ezgi Aydaş |
| **Öğrenci No** | 1250505008 |
| **Üniversite / Bölüm** | Kırklareli Üniversitesi, Yazılım Mühendisliği |

## Özellikler

- Yalnızca Java standart kütüphanesi kullanılır (`java.net`, `java.io`, `java.util.concurrent`).
- Sunucu 1989 numaralı portu dinler.
- Tarayıcıya geçerli bir HTTP/1.1 yanıtı döndürülür.
- Sayfada ad soyad `<h1>`, öğrenci numarası `<h2>` etiketi ile gösterilir.
- Biyografi, renk, yazı tipi ve kutu tasarımı gibi CSS biçimlendirmeleri ile hazırlanmıştır.
- Türkçe karakterler için `UTF-8` kodlaması kullanılır.
- Her istemci bağlantısı, sabit boyutlu bir iş parçacığı havuzunda (10 iş parçacığı) ayrı olarak işlenir.
- Desteklenmeyen HTTP metotları için `405 Method Not Allowed` yanıtı döndürülür.

## Proje Yapısı

```
JavaWebServer/
└── src/
    ├── WebServerApp.java          # Sunucuyu başlatır, bağlantıları kabul eder
    ├── ClientHandler.java         # Her istemciyi işler, HTTP yanıtını oluşturur
    ├── BioContentProvider.java    # İçerik sağlayıcı arayüzü (interface)
    └── HtmlBioProvider.java       # Biyografi HTML içeriğini üretir
```

| Dosya | Sorumluluğu |
|---|---|
| `WebServerApp` | `ServerSocket` ile portu dinler, gelen bağlantıları `accept()` ile kabul eder ve iş parçacığı havuzuna iletir. |
| `ClientHandler` | `Runnable` arayüzünü uygular. İstek satırını okur, HTTP yanıt başlıklarını ve gövdesini istemciye yazar. |
| `BioContentProvider` | Sayfa içeriğinin hangi sözleşme ile sağlanacağını tanımlayan arayüzdür (`getBioHtml()`). |
| `HtmlBioProvider` | `BioContentProvider` arayüzünü uygular ve biçimlendirilmiş HTML sayfasını üretir. |

## Çalışma Mantığı

1. `WebServerApp`, `ServerSocket(1989)` ile portu dinlemeye başlar.
2. Tarayıcı bağlandığında `accept()` metodu bir `Socket` nesnesi döndürür.
3. Bu soket, bir `ClientHandler` nesnesine verilir ve iş parçacığı havuzunda çalıştırılır.
4. `ClientHandler`, istek satırını (örneğin `GET / HTTP/1.1`) ve başlıkları okur.
5. İstek `GET` ise `BioContentProvider` üzerinden HTML içeriği alınır ve `200 OK` yanıtıyla gönderilir.
6. Farklı bir metot ise `405 Method Not Allowed` yanıtı gönderilir.
7. Yanıt tamamlandıktan sonra bağlantı kapatılır (`Connection: close`).

Örnek HTTP yanıtı:

```
HTTP/1.1 200 OK
Content-Type: text/html; charset=UTF-8
Content-Length: <gövde uzunluğu>
Connection: close

<!DOCTYPE html>...
```

## SOLID Prensipleri

| Prensip | Projedeki Karşılığı |
|---|---|
| **S** – Single Responsibility | Her sınıfın tek bir görevi vardır: `WebServerApp` bağlantı kabul eder, `ClientHandler` isteği işler, `HtmlBioProvider` içeriği üretir. |
| **O** – Open/Closed | Yeni bir içerik türü (örneğin farklı bir sayfa tasarımı) eklemek için `ClientHandler` değiştirilmez, yeni bir `BioContentProvider` gerçekleştirimi yazılır. |
| **L** – Liskov Substitution | `BioContentProvider` arayüzünü uygulayan her sınıf, `ClientHandler` içinde davranışı bozmadan birbirinin yerine kullanılabilir. |
| **I** – Interface Segregation | `BioContentProvider` yalnızca tek bir metot içeren küçük bir arayüzdür. Sınıflar gereksiz metotları uygulamaya zorlanmaz. |
| **D** – Dependency Inversion | `ClientHandler`, somut `HtmlBioProvider` sınıfına değil `BioContentProvider` soyutlamasına bağlıdır. Bağımlılık, `WebServerApp` içinde constructor aracılığıyla verilir. |

## Gereksinimler

- JDK 11 veya üzeri (Java 8 ve üzeri ile de derlenmesi beklenir)
- Herhangi bir ek kütüphane gerekmez.

Kurulu sürümü kontrol etmek için:

```bash
java -version
javac -version
```

## Derleme ve Çalıştırma

### Terminal ile

```bash
git clone <repo-adresi>
cd JavaWebServer/src
javac *.java
java WebServerApp
```

Konsolda şu çıktıyı görmelisiniz:

```
Sunucu başlatıldı: http://localhost:1989
```

### IDE ile (IntelliJ IDEA, Eclipse, VS Code)

1. Projeyi IDE'de açın.
2. `WebServerApp.java` dosyasını açın.
3. `main` metodunu çalıştırın (Run).

## Kullanım

Sunucu çalışırken tarayıcınızın adres çubuğuna aşağıdaki adresi yazın:

```
http://localhost:1989
```

Aynı ağdaki başka bir cihazdan erişmek için `localhost` yerine sunucuyu çalıştıran bilgisayarın IP adresini kullanın (örneğin `http://192.168.1.10:1989`). Güvenlik duvarı 1989 numaralı porta izin vermelidir.

Sunucuyu durdurmak için terminalde `Ctrl + C` tuşlarına basın ya da IDE'deki Stop butonunu kullanın.

## Sık Karşılaşılan Sorunlar

**`Address already in use: bind` hatası**
1989 numaralı port başka bir işlem tarafından kullanılıyordur. Genellikle sunucunun önceki bir örneği hâlâ çalışıyordur. Önceki örneği kapatın ya da Windows'ta şu komutlarla portu kullanan işlemi bulup sonlandırın:

```bash
netstat -ano | findstr :1989
taskkill /PID <PID> /F
```

**`javac` komutu tanınmıyor**
JDK kurulu değildir ya da `PATH` ortam değişkenine eklenmemiştir. JDK kurup `PATH` ayarını kontrol edin ya da projeyi bir IDE ile çalıştırın.

**Türkçe karakterler bozuk görünüyor**
Sunucu `Content-Type: text/html; charset=UTF-8` başlığını gönderir. Kaynak dosyaların `UTF-8` olarak kaydedildiğinden emin olun.

## Kullanılan Teknolojiler

- Java (`java.net.ServerSocket`, `java.net.Socket`)
- Java I/O (`BufferedReader`, `InputStreamReader`, `OutputStream`)
- Java Concurrency (`ExecutorService`, `Executors`)
- HTML5 ve CSS3

## Not

Bu proje, Java ile socket programlama ve SOLID prensiplerini uygulamalı olarak göstermek amacıyla ödev kapsamında hazırlanmıştır.
