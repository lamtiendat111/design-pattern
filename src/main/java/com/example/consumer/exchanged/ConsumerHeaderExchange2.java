package com.example.consumer.exchanged;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.util.HashMap;
import java.util.Map;

public class ConsumerHeaderExchange2 {
    private static final String EXCHANGE_NAME = "HeaderExchange";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = "2_queue"+EXCHANGE_NAME;
        Map<String, Object> header = new HashMap<>();
        header.put("header","header1");
        header.put("group","1");
        header.put("x-match","all");

        System.out.println(queueName);
//        String queueName = "queueNameIsDirect";

        channel.queueBind(queueName, EXCHANGE_NAME, "",header);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            try {
                try {
                    System.out.println(delivery.getProperties().getHeaders());;
                    doWork(message);
                    System.out.println("done");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            finally {
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
            }

        };

        channel.basicConsume(queueName, false, deliverCallback, consumerTag -> { });
    }
    private static void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }


}