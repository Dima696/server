import java.io.*;
import java.net.Socket;

public class Customer {
    public static void main ( String[] args ) throws IOException {
      var clientSocket = new Socket("localhost", 31);
      var reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Server access allowed!" + "\n"+ "Enter your name?");
      var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      var out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      String word = reader.readLine();
      out.write(word + "\n");
      out.flush();
      String serverWord = in.readLine();
      System.out.println(serverWord);

    }
}
