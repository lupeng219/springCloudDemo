package com.lupeng.customer.mq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MqClient {

    //生产消息
    public static void produce(String message) throws Exception {
        //本地的的BrokerServer.SERVICE_PORT 创建SOCKET
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            System.out.println("produce:"+message);
            out.println(message);
            out.flush();
        }
    }

    //消费消息
    public static String consume() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            //先向消息队列发送命令
            out.println("CONSUME");
            out.flush();

            //再从消息队列获取一条消息
            String message = in.readLine();
            System.out.println("consume:"+message);
            return message;
        }
    }

}