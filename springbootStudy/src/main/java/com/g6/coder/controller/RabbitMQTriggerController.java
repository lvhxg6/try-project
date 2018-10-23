package com.g6.coder.controller;

import com.g6.coder.rabbitmq.bean.User;
import com.g6.coder.rabbitmq.sender.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by huixiaolv on 23/10/2018.
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitMQTriggerController {

    @Autowired
    private HelloSender helloSender1;


    @GetMapping("/hello")
    public void hello() {
        helloSender1.send(new User("hx","bj", new Random().nextInt(60)));
    }

    @GetMapping("/oneToMany")
    public void oneToMany(){
        for(int i=0;i<10;i++){
            helloSender1.send(new User("hx","bj", new Random().nextInt(60)));
        }
    }

    @GetMapping("/topic")
    public void topic(){
        helloSender1.topicSend();
    }

    @GetMapping("/fanout")
    public void fanout(){
        helloSender1.fanoutSend();
    }

}
