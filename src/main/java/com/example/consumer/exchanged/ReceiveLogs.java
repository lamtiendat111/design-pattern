package com.example.consumer.exchanged;

import com.rabbitmq.client.*;

public class ReceiveLogs {
    private static final String EXCHANGE_NAME = "logs1";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare();
        String queueName = "queue_"+EXCHANGE_NAME;
        channel.queueDeclare(queueName,true,false,false,null);
//        String queueName = "logs";
        System.out.println(queueName);
        channel.queueBind(queueName, EXCHANGE_NAME, "key.direct.enable");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            try {
                try {
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