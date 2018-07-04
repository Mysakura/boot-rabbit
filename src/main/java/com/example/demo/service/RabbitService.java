package com.example.demo.service;

import com.example.demo.conf.RabbitConfiguration;
import com.example.demo.request.RabbitRequest;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: boot-rabbitmq
 * @description:
 * @author: 001977
 * @create: 2018-07-02 17:40
 */
@Component
public class RabbitService {

    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitService(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate, RabbitTemplate rabbitTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendDirect(RabbitRequest rabbitRequest){
        rabbitTemplate.convertAndSend(RabbitConfiguration.direct,RabbitConfiguration.directRoutingA,rabbitRequest);
        rabbitTemplate.convertAndSend(RabbitConfiguration.direct,RabbitConfiguration.directRoutingB,rabbitRequest);
        // 对于返回消息，必须实现这个。没有验证成功
//        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
//            @Override
//            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//
//            }
//        });
        // 对于确认，必须实现这个。没有验证成功
//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//                // CorrelationData-客户端在发送原始消息时提供的对象
//                // ack-成功失败
//                // cause-原因
//                System.out.println(ack + "," + cause);
//            }
//        });
    }

    @RabbitListener(queues = {"queueA","queueB"})
    public void receiveDirect(RabbitRequest rabbitRequest){
        System.out.println("Direct:Receive:" + rabbitRequest);
    }

    public void sendFanout(RabbitRequest rabbitRequest){
        rabbitTemplate.convertAndSend(RabbitConfiguration.fanout,"",rabbitRequest);
    }

    @RabbitListener(queues = {"queueC","queueD"})
    public void receiveFanout(RabbitRequest rabbitRequest){
        System.out.println("Fanout:Receive:" + rabbitRequest);
    }

    public void sendTopic(RabbitRequest rabbitRequest){
        rabbitTemplate.convertAndSend(RabbitConfiguration.topic, rabbitRequest.getRoutingKey(), rabbitRequest);
    }

    @RabbitListener(queues = {"queueE"})
    public void receiveTopicE(RabbitRequest rabbitRequest){
        System.out.println("Topic:Receive:[" + RabbitConfiguration.topicRoutingE + "]" + rabbitRequest);
    }

    @RabbitListener(queues = {"queueF"})
    public void receiveTopicF(RabbitRequest rabbitRequest){
        System.out.println("Topic:Receive:[" + RabbitConfiguration.topicRoutingF + "]" + rabbitRequest);
    }
}
