package com.lupeng.customer.mq;

public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
        client.produce("SEND:Hello Worlds");
    }
}
