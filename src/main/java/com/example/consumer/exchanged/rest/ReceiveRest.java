package com.example.consumer.exchanged.rest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("home")
public class ReceiveRest {

    @GetMapping("receive")
    public String receiveMessage(String key) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String EXCHANGE_NAME="MessageService";
        String queueName = "queue" + EXCHANGE_NAME;
        Map<String, Object> header = new HashMap<>();
        header.put("header", "header1");
        header.put("x-match", "any");
        channel.queueDeclare(queueName, true, false, false, null);

        System.out.println(queueName);
//        String queueName = "queueNameIsDirect";

        channel.queueBind(queueName, EXCHANGE_NAME, key, header);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        AtomicReference<String> result = new AtomicReference<>("");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            result.set(message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        };

        channel.basicConsume(queueName, false, deliverCallback, consumerTag -> {
        });
        channel.close();
        connection.close();
        return result.toString();
    }
}
