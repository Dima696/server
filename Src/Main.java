import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    try {
            try {

                var clientSocket = new Socket("localhost", 31);

                var reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Server access allowed!" + "\n" + "Enter your name?");

                var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                var out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                String serverWord = in.readLine();
                System.out.println(serverWord);
            } catch (NullPointerException e) {
                System.out.println(e + "Client closed...");
                clientSocket.close();
                in.close();
                out.close();
                System.out.println(e);
            }
        } catch (IOException e) {
            System.err.println(e);
        }


    }
}

