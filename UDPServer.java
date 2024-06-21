import java.io.IOException;
import java.net.*;
public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(65432)) {
            byte[] buffer = new byte[1024];
            System.out.println("Server is listening on port 65432");
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);
                String response = "Echo: " + received;
                DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.length(),
                        packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}


