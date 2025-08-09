import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class HelloServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9999);
        System.out.println("UDP Hello Server is running...");

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // Receive from client
        socket.receive(packet);
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Client says: " + message);

        // Send response back
        String reply = "Hello from Server!";
        byte[] sendData = reply.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(
                sendData, sendData.length, packet.getAddress(), packet.getPort());
        socket.send(sendPacket);

        socket.close();
    }
}
