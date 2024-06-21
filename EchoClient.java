import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        // Server IP and port number to connect to
        String serverAddress = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to the server");

            // Create input and output streams for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create a reader for user input
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            System.out.println("Enter messages to send to the server (type 'exit' to quit):");

            // Read messages from the user and send them to the server
            while (!(message = userInput.readLine()).equalsIgnoreCase("exit")) {
                out.println(message);
                System.out.println("Server response: " + in.readLine());
            }

            System.out.println("Disconnected from the server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
