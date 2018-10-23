package com.g6.coder.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by huixiaolv on 23/10/2018.
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiveC {

    @RabbitHandler
    private void process(String msg){
        System.out.println("FanoutReceiveC:"+msg);
    }

}
