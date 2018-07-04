package com.example.demo.conf;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: boot-rabbitmq
 * @description:
 * @author: 001977
 * @create: 2018-07-02 17:45
 */
@Configuration
public class RabbitConfiguration {

    /**
     * If not conf the exchange
     * Channel shutdown: channel error; protocol method: #method<channel.close>(reply-code=404, reply-text=NOT_FOUND - no exchange 'hello.direct' in vhost '/', class-id=60, method-id=40)
     *
     */

    public static final String direct = "hello.direct";
    public static final String fanout = "hello.fanout";
    public static final String topic = "hello.topic";

    public static final String directRoutingA = "direct.routing.A";
    public static final String directRoutingB = "direct.routing.B";

    public static final String topicRoutingE = "*.rabbit.*";
    public static final String topicRoutingF = "write.#";

    //------------Direct-------------

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(direct);
    }

    @Bean
    public Queue queueA(){
        return new Queue("queueA");
    }

    @Bean
    public Queue queueB(){
        return new Queue("queueB");
    }


    @Bean
    public Binding bindingQueueA(Queue queueA, DirectExchange directExchange){
        return BindingBuilder.bind(queueA).to(directExchange).with(directRoutingA);
    }

    @Bean
    public Binding bindingQueueB(Queue queueB, DirectExchange directExchange){
        return BindingBuilder.bind(queueB).to(directExchange).with(directRoutingB);
    }

    //------------Fanout-------------

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(fanout);
    }

    @Bean
    public Queue queueC(){
        return new Queue("queueC");
    }

    @Bean
    public Queue queueD(){
        return new Queue("queueD");
    }

    @Bean
    public Binding bindingQueueC(Queue queueC, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueC).to(fanoutExchange);
    }

    @Bean
    public Binding bindingQueueD(Queue queueD, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueD).to(fanoutExchange);
    }

    //------------Topic-------------

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(topic);
    }

    @Bean
    public Queue queueE(){
        return new Queue("queueE");
    }

    @Bean
    public Queue queueF(){
        return new Queue("queueF");
    }

    @Bean
    public Binding bindingQueueE(Queue queueE, TopicExchange topicExchange){
        return BindingBuilder.bind(queueE).to(topicExchange).with(topicRoutingE);
    }

    @Bean
    public Binding bindingQueueF(Queue queueF, TopicExchange topicExchange){
        return BindingBuilder.bind(queueF).to(topicExchange).with(topicRoutingF);
    }

}
