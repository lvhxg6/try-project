package com.g6.coder.rabbitmq.sender;

import com.g6.coder.rabbitmq.bean.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by huixiaolv on 23/10/2018.
 *
 * rabbitMQTemplate.convertAndSend(String routeKey,Object obj);
 * rabbitMQTemplate.convertAndSend(String exchange,String routeKey,Object obj)
 *
 *  publisher 将消息发送给Exchange，Exchange根据routeKey将消息路由到指定的队列
 *  consumer  监听队列消息，当队列中有消息的时候，获取消息进行处理
 *
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitMQTemplate;

    public void send(User user){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitMQTemplate.convertAndSend("hello", user);
    }

    public void topicSend(){
        String topic1 = "我是第一个topic,topic.message";
        String topic2 = "i am second topic,topic.messages";
        this.rabbitMQTemplate.convertAndSend("exchange","topic.message",topic1);
        this.rabbitMQTemplate.convertAndSend("exchange","topic.messages",topic2);
    }

    public void fanoutSend(){
        String msg = "fanout send : 隔壁村老王家的狗生了20头小猪";
        this.rabbitMQTemplate.convertAndSend("fanoutExchange","bd.ex",msg);
    }

}
