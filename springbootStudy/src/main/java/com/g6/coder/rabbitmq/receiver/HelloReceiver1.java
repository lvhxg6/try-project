package com.g6.coder.rabbitmq.receiver;

import com.g6.coder.rabbitmq.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by huixiaolv on 23/10/2018.
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver1 {

    @RabbitHandler
    private void process(User message){
        System.out.println("receiver2 process msg : "+message);
    }


}
