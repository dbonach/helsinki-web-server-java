
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HelloBrowser {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Where to? ");
       String address = input.nextLine();
        int port = 80;
        
        System.out.println();
        
        Socket socket = new Socket(address, port);
        
        PrintWriter author = new PrintWriter(socket.getOutputStream());
        author.println("GET / HTTP/1.1");
        author.println("Host: " + address);
        author.println();
        author.flush();
        
        Scanner reader = new Scanner(socket.getInputStream());
        while (reader.hasNextLine()) {
            System.out.println(reader.nextLine());
        }
        
    }
}
