import java.io.IOException;
import java.net.*;
public class UDPClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 65432;
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buffer = new byte[1024];
            String message = "Hello, Server! im ready";
            InetAddress address = InetAddress.getByName(hostname);
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, port);
            socket.send(packet);
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String response = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Server response: " + response);
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
