import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    try {
            try {
                ServerSocket serverSocket = new ServerSocket(31);
                System.out.println("Server started !");
                Socket clientSocket = serverSocket.accept();
                try {
                    var out = new PrintWriter(clientSocket.getOutputStream(), true);
                    var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String name = in.readLine();
                    out.flush();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server closed...!");
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
