import java.io.*;
import java.net.Socket;


public class Customer {
    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static BufferedReader reader;

    public static void main ( String[] args ) throws NullPointerException, IOException {
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

        } finally {
            clientSocket.close();
            in.close();
            out.close();

        }
    }
}


