import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable {

    private final Socket clientSocket;
    private final BioContentProvider contentProvider;

    public ClientHandler(Socket clientSocket, BioContentProvider contentProvider) {
        this.clientSocket = clientSocket;
        this.contentProvider = contentProvider;
    }

    @Override
    public void run() {
        try (Socket socket = clientSocket;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             OutputStream out = socket.getOutputStream()) {

            String requestLine = in.readLine();          // örn: GET / HTTP/1.1
            if (requestLine == null || requestLine.isEmpty()) {
                return;
            }

            // Başlık satırlarını boş satıra kadar oku
            String line;
            while ((line = in.readLine()) != null && !line.isEmpty()) {
                // header'lar bu ödevde kullanılmıyor
            }

            String method = requestLine.split(" ")[0];

            if ("GET".equalsIgnoreCase(method)) {
                byte[] body = contentProvider.getBioHtml().getBytes(StandardCharsets.UTF_8);
                sendResponse(out, "200 OK", "text/html; charset=UTF-8", body);
            } else {
                byte[] body = "405 Method Not Allowed".getBytes(StandardCharsets.UTF_8);
                sendResponse(out, "405 Method Not Allowed", "text/plain; charset=UTF-8", body);
            }
        } catch (IOException e) {
            System.err.println("İstemci işlenirken hata: " + e.getMessage());
        }
    }

    private void sendResponse(OutputStream out, String status, String contentType, byte[] body)
            throws IOException {
        String headers = "HTTP/1.1 " + status + "\r\n"
                + "Content-Type: " + contentType + "\r\n"
                + "Content-Length: " + body.length + "\r\n"
                + "Connection: close\r\n"
                + "\r\n";
        out.write(headers.getBytes(StandardCharsets.UTF_8));
        out.write(body);
        out.flush();
    }
}