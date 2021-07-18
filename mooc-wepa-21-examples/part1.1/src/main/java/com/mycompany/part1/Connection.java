/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.part1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author dbonach
 */
public class Connection {

    public static void main(String[] args) throws IOException {
//        String address = "www.helsinki.fi";
        String address = "www.mooc.fi";
                
        int port = 80;

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
