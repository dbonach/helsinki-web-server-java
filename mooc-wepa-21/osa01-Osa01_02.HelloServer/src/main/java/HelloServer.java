

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        
        while (true) {
            Socket socket = server.accept();
            
            Scanner reader = new Scanner(socket.getInputStream());
            
            PrintWriter author = new PrintWriter(socket.getOutputStream());
            
//            if (reader.hasNextLine()) {
//                String header = reader.nextLine();
//                if (header.split(" ")[1].equals("/quit")) {
//                    
//                    author.print("HTTP/1.1 202 Accepted\r\n");
//                    author.print("\r\n");
//                    
//                    System.out.println("Closing the server");
//                    
//                    closeConnection(author, reader, socket);
//                    break;
//                }
//            }
            
            System.out.println("There's a new connection!");
            
            author.print("HTTP/1.0 200 OK\r\n");
            author.print("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
            author.print("Server: Apache/0.8.4\r\n");
            author.print("Content-Type: text/html;charset=UTF-8\r\n");
            author.print("Content-Length: 714\r\n");
            author.print("Expires: Sat, 01 Jan 2011 00:59:59 GMT\r\n");
            author.print("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
            author.print("\r\n");
            
            printFile(author);

            closeConnection(author, reader, socket);
        }
    }

    public static void printFile(PrintWriter author) throws IOException{
        Path myPath = Paths.get("/home/dbonach/NetBeansProjects/helsinki-java-spring-boot"
                + "/mooc-wepa-21/osa01-Osa01_02.HelloServer/index.html");
        List<String> lines = Files.readAllLines(myPath, StandardCharsets.UTF_8);
        lines.forEach(line -> author.println(line));
    }
    
    public static void closeConnection(PrintWriter author, Scanner reader, Socket socket) throws IOException {
        author.flush();
        reader.close();
        author.close();
        socket.close();
    }
}
