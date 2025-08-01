import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started, waiting for connection...");
        Socket socket = server.accept();
        System.out.println("Client connected.");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
        String line, resp;
        while (true) {
            line = in.readLine();
            if (line == null || line.equals("exit")) break;
            System.out.println("Client says: " + line);
            System.out.print("Server says: ");
            resp = user.readLine();
            out.println(resp);
            if (resp.equals("exit")) break;
        }
        socket.close();
        server.close();
        System.out.println("Connection closed.");
    }
}
