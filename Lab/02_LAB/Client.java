import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to server...");
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server.");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
        String line, resp;
        while (true) {
            System.out.print("Client says: ");
            line = user.readLine();
            out.println(line);
            if (line.equals("exit")) break;
            resp = in.readLine();
            if (resp == null || resp.equals("exit")) break;
            System.out.println("Server says: " + resp);
        }
        socket.close();
        System.out.println("Connection closed.");
    }
}
