import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServerApp {

    private static final int PORT = 1989;

    public static void main(String[] args) {
        BioContentProvider bioProvider = new HtmlBioProvider();
        ExecutorService pool = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu başlatıldı: http://localhost:" + PORT);

            while (true) {
                Socket client = serverSocket.accept();   // bağlantı gelene kadar bekler
                pool.execute(new ClientHandler(client, bioProvider));
            }
        } catch (IOException e) {
            System.err.println("Sunucu hatası: " + e.getMessage());
        } finally {
            pool.shutdown();
        }
    }
}