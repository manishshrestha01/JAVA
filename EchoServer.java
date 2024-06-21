
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        // Port number to listen on
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Listening on port " + port);

            // Wait for a connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams for the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            // Read messages from the client and echo them back
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Echo: " + message);
            }

            System.out.println("Client disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
