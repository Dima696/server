import java.io.*;
import java.net.Socket;


public class Customer {
    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static BufferedReader reader;

    public static void main ( String[] args ) throws NullPointerException, IOException {
        try {

            try (var clientSocket = new Socket("localhost", 31); var reader = new BufferedReader(new InputStreamReader(System.in));
                 var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); var out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

                System.out.println("Server access allowed!" + "\n" + "Enter your name?");
                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                String serverWord = in.readLine();
                System.out.println(serverWord);
            }
//                in.close();
//                out.close();

        } catch (NullPointerException e) {
            System.out.println();
        }
    }
}

