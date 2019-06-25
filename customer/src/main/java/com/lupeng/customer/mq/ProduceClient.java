package com.lupeng.customer.mq;

public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient.produce("SEND:Hello Worlds");
    }
}
