
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HelloRedirectLoop {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        
        int i = 0;
        
        while (true) {
            Socket socket = server.accept();
            
            Scanner reader = new Scanner(socket.getInputStream());
            
            PrintWriter author = new PrintWriter(socket.getOutputStream());
            
//            i++;
//            System.out.println("There's a new connection! n:" + i);

            if (reader.hasNextLine()) {
                String header = reader.nextLine();
                if (header.split(" ")[1].equals("/quit")) {
                    author.print("HTTP/1.1 202 Accepted\r\n");
                    author.print("\r\n");
                    
                    System.out.println("Closing the server");
                    
                    closeConnection(author, reader, socket);
                    break;
                }
            }
            
            author.print("HTTP/1.1 302 Found\r\n");
            author.print("Location: http://localhost:8080 \r\n");
            author.print("\r\n");
            
            closeConnection(author, reader, socket);
        }
    }
    
    public static void closeConnection(PrintWriter author, Scanner reader, Socket socket) throws IOException {
        author.flush();
        reader.close();
        author.close();
        socket.close();
    }
}
