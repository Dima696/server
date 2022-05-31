import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main ( String[] args ) throws IOException {

       try (ServerSocket serverSocket = new ServerSocket(31);
             Socket clientSocket = serverSocket.accept();
             var out = new PrintWriter(clientSocket.getOutputStream(), true);
             var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Server started !");

            String name = in.readLine();
            out.flush();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        }
//        clientSocket.close();
//        in.close();
//        out.close();
//        System.out.println("Server closed...!");
//        serverSocket.close();
    }
}


