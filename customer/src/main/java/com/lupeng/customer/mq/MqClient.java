package com.lupeng.customer.mq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 消息处理中心 : 如果接收到的信息包含"SEND"字符串,即视为生产者发送的消息,消息处理中心需要将此信息存储等待消费者消费
 *
 * 消息处理中心 : 如果接受到的信息为CONSUME，既视为消费者发送消费请求，需要将存储的消息队列头部的信息转发给消费者，然后将此消息从队列中移除
 *
 * 消息处理中心 : 如果消息处理中心存储的消息满3条仍然没有消费者进行消费,则不再接受生产者的生产请求
 *
 * 消息生产者：需要遵循协议将生产的消息头部增加＂SEND:＂ 表示生产消息
 *
 * 消息消费者：需要遵循协议向消息处理中心发送＂CONSUME＂字符串表示消费消息
 *
 * 新建一个 Broker 类，内部维护一个 ArrayBlockingQueue 队列，提供生产消息和消费消息的方法， 仅仅具备存储服务功能
 * 新建一个 BrokerServer 类,将 Broker 发布为服务到本地9999端口，监听本地9999端口的 Socket 链接，在接受的信息中进行我们的协议校验, 这里 仅仅具备接受消息,校验协议,转发消息功能;
 * 新建一个 MqClient 类,此类提供与本地端口9999的Socket链接 , 仅仅具备生产消息和消费消息的方法
 * 测试：新建两个 MyClient 类对象，分别执行其生产方法和消费方法
 */
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
