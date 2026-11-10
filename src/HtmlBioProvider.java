public class HtmlBioProvider implements BioContentProvider {

    private final String fullName = "Ezgi Aydaş";
    private final String studentId = "1250505008";

    @Override
    public String getBioHtml() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"tr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Öğrenci Biyografisi</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "            background-color: #4A154B;\n" + // Koyu mürdüm arka plan
                "            color: #2D0B2E;\n" +
                "            margin: 0;\n" +
                "            padding: 40px;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "        .card {\n" +
                "            background-color: #EFE5F7;\n" + // Açık lila metin kartı
                "            padding: 40px 50px;\n" +
                "            border-radius: 16px;\n" +
                "            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.25);\n" +
                "            max-width: 750px;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        h1 {\n" +
                "            color: #3A0C3B;\n" +
                "            font-size: 2.2em;\n" +
                "            margin-bottom: 5px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        h2 {\n" +
                "            color: #5A205C;\n" +
                "            font-size: 1.4em;\n" +
                "            margin-top: 5px;\n" +
                "            font-weight: 500;\n" +
                "            border-bottom: 2px solid #802A83;\n" +
                "            padding-bottom: 12px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        /* Sol dikey çizgili ortak başlık stili */\n" +
                "        h3 {\n" +
                "            color: #3A0C3B;\n" +
                "            font-size: 1.35em;\n" +
                "            font-weight: 700;\n" +
                "            margin-top: 25px;\n" +
                "            margin-bottom: 12px;\n" +
                "            border-left: 5px solid #802A83;\n" +
                "            padding-left: 12px;\n" +
                "        }\n" +
                "        /* Blok Kutusu Tasarımı */\n" +
                "        .section-block {\n" +
                "            background-color: #DFCEF0;\n" +
                "            padding: 18px 22px;\n" +
                "            border-radius: 12px;\n" +
                "            margin-top: 20px;\n" +
                "            margin-bottom: 20px;\n" +
                "            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);\n" +
                "            border: 1px solid #D1BBE6;\n" +
                "        }\n" +
                "        .section-block h3 {\n" +
                "            margin-top: 0;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        p {\n" +
                "            line-height: 1.8;\n" +
                "            font-size: 1.05em;\n" +
                "            color: #2D0B2E;\n" +
                "            margin-bottom: 18px;\n" +
                "            text-align: justify;\n" +
                "        }\n" +
                "        .section-block ul {\n" +
                "            margin: 0;\n" +
                "            padding-left: 28px;\n" +
                "        }\n" +
                "        /* Kalın, italik ve koyu mürdüm liste maddesi stili */\n" +
                "        .section-block li {\n" +
                "            line-height: 1.8;\n" +
                "            font-size: 1.05em;\n" +
                "            color: #3A0C3B;\n" +
                "            font-weight: bold;\n" +
                "            font-style: italic;\n" +
                "        }\n" +
                "        /* Biçimlendirme Sınıfları */\n" +
                "        .major-title {\n" +
                "            color: #7B1FA2;\n" +
                "            font-weight: bold;\n" +
                "            text-decoration: overline underline;\n" +
                "        }\n" +
                "        .hobbies {\n" +
                "            color: #B71C1C;\n" +
                "            font-weight: bold;\n" +
                "            font-style: italic;\n" +
                "            font-family: 'Trebuchet MS', sans-serif;\n" +
                "        }\n" +
                "        .tech-stack {\n" +
                "            color: #4A154B;\n" +
                "            background-color: #DFCEF0;\n" +
                "            padding: 2px 6px;\n" +
                "            border-radius: 4px;\n" +
                "            font-family: Consolas, 'Liberation Mono', monospace;\n" +
                "            letter-spacing: 1px;\n" +
                "            font-weight: 600;\n" +
                "            font-style: normal;\n" +
                "        }\n" +
                "        .solid-concept {\n" +
                "            color: #C62828;\n" +
                "            font-weight: 800;\n" +
                "            letter-spacing: 1.5px;\n" +
                "            text-transform: uppercase;\n" +
                "            font-style: normal;\n" +
                "        }\n" +
                "        .data-engineering {\n" +
                "            color: #1B5E20;\n" +
                "            font-family: Georgia, 'Times New Roman', serif;\n" +
                "            text-decoration: underline;\n" +
                "            font-weight: bold;\n" +
                "            font-style: normal;\n" +
                "        }\n" +
                "        .cyber-security {\n" +
                "            color: #880E4F;\n" +
                "            font-family: 'Courier New', Courier, monospace;\n" +
                "            text-decoration: underline;\n" +
                "            font-weight: bold;\n" +
                "            font-style: normal;\n" +
                "        }\n" +
                "        .badge {\n" +
                "            display: inline-block;\n" +
                "            background-color: #4A154B;\n" +
                "            color: #EFE5F7;\n" +
                "            padding: 6px 14px;\n" +
                "            border-radius: 20px;\n" +
                "            font-size: 0.9em;\n" +
                "            margin-top: 15px;\n" +
                "            font-weight: 600;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"card\">\n" +
                "        <h1>" + fullName + "</h1>\n" +
                "        <h2>Öğrenci No: " + studentId + "</h2>\n" +
                "        <br>\n" +
                "        \n" +
                "        <!-- Başlık 1: Hakkımda -->\n" +
                "        <h3>Hakkımda</h3>\n" +
                "        <p>\n" +
                "            Merhaba, ben " + fullName + ". 19 yaşındayım ve Kırklareli Üniversitesi <span class=\"major-title\">Yazılım Mühendisliği</span> bölümü 2. sınıf öğrencisi olarak eğitimime devam etmekteyim.\n" +
                "        </p>\n" +
                "        \n" +
                "        <!-- Başlık 2: Hobilerim -->\n" +
                "        <h3>Hobilerim</h3>\n" +
                "        <p>\n" +
                "            Akademik çalışmalarımın ve yoğun kodlama temposunun yanında, zihinsel ve fiziksel dengemi korumaya büyük önem veriyorum. Boş zamanlarımda stratejik düşünme becerilerimi geliştiren <span class=\"hobbies\">satranç oynamaktan</span>, takım ruhunu hissettiğim <span class=\"hobbies\">voleybol maçları yapmaktan</span>, açık havada uzun <span class=\"hobbies\">yürüyüşlere çıkmaktan</span> ve yabancı <span class=\"hobbies\">diziler izlemekten</span> büyük keyif alıyorum.\n" +
                "        </p>\n" +
                "        \n" +
                "        <!-- Başlık 3: İlgi Alanlarım -->\n" +
                "        <h3>İlgi Alanlarım</h3>\n" +
                "        <p>\n" +
                "            Yazılım dünyasında ise temelleri sağlam atmayı hedefleyerek <span class=\"tech-stack\">C, C++ ve Java</span> dilleri üzerine odaklanıyorum. Projelerimde modüler, sürdürülebilir ve yüksek kaliteli kod yapısı oluşturabilmek adına nesne yönelimli tasarım prensipleri (<span class=\"solid-concept\">SOLID</span>) aktif bir şekilde uyguluyor; bellek yönetimi ve veri yapılarını alt seviyeden öğrenmeye özen gösteriyorum.\n" +
                "        </p>\n" +
                "        <p>\n" +
                "            Gelecekte profesyonel kariyerimi büyük ölçekli veri mimarilerinin kurgulandığı <span class=\"data-engineering\">Veri Mühendisliği</span> ve sistem güvenliğinin sağlandığı <span class=\"cyber-security\">Siber Güvenlik</span> alanlarında şekillendirmeyi hedefliyorum. Dağınık sistemler, veri akış hatları ve güvenli yazılım geliştirme süreçleri üzerine araştırmalarımı kararlılıkla sürdürmekteyim.\n" +
                "        </p>\n" +
                "        \n" +
                "        <!-- Kulüp Etkinlikleri Bloğu -->\n" +
                "        <div class=\"section-block\">\n" +
                "            <h3>Kulüp Etkinlikleri</h3>\n" +
                "            <ul>\n" +
                "                <li>Teknofest Kulübü (Core Team Projeler Ekibi)</li>\n" +
                "                <li>Oyun Geliştirme ve Tasarlama Kulübü (Sponsorluk Ekibi)</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        \n" +
                "        <!-- Teknofest Projeleri Bloğu -->\n" +
                "        <div class=\"section-block\">\n" +
                "            <h3>Teknofest Projeleri</h3>\n" +
                "            <ul>\n" +
                "                <li>Çelikkubbe Hava Savunma Sistemleri</li>\n" +
                "                <li>FPV Drone İzleme</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        \n" +
                "        <!-- Öğrenilen Diller Bloğu -->\n" +
                "        <div class=\"section-block\">\n" +
                "            <h3>Öğrenilen Diller</h3>\n" +
                "            <ul>\n" +
                "                <li>İngilizce</li>\n" +
                "                <li>Rusça</li>\n" +
                "                <li>Fransızca</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        \n" +
                "        <div class=\"badge\">Kırklareli Üniversitesi - Yazılım Mühendisliği</div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}