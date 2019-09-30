package com.cloud3.web.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: HeYongLiu
 * @create: 08-20-2019
 * @description: 简单socket测试
 **/
public class SocClient {

    private String host = "127.0.0.1";
    private int port = 8181;

    public SocClient() {
    }

    public SocClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void client() {
        try {
            Socket client = new Socket(host, port);
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                Scanner in = new Scanner(System.in);
                while (in.hasNext()) {
                    String accept = in.nextLine();
                    out.println(accept);
                    System.out.println(accept);
                }
                in.close();
                while (true) {
                    String get = input.readLine();
                    System.out.println(get);
                }
            } finally {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocClient().client();
    }

}
