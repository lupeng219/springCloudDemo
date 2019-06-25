package com.lupeng.customer.mq;

public class ConsumeClient {
    public static void main(String[] args) throws Exception{
        MqClient mqClient = new MqClient();
        String message = mqClient.consume();
        System.out.println("获取的消息为：" + message);
    }
}
