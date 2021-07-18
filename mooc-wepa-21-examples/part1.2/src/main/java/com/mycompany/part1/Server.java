/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.part1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author dbonach
 */
public class Server {
        public static void main(String[] args) throws IOException {
            
            ServerSocket server = new ServerSocket(8080);
            
            while (true) {
                Socket socket = server.accept();
                
                Scanner reader = new Scanner(socket.getInputStream());
                
                PrintWriter author = new PrintWriter(socket.getOutputStream());
                
                System.out.println("There's a new connection!");
                
                author.println("HTTP/1.1 301 Moved Permanently");
                author.println("Location: https://www.mooc.fi/");
                author.println();
                author.flush();
                
                
                reader.close();
                author.close();
                socket.close();
            }
            
            
        }
            
}
