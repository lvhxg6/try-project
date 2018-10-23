package com.g6.coder.rabbitmq;

import com.g6.coder.rabbitmq.bean.User;
import com.g6.coder.rabbitmq.sender.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * Created by huixiaolv on 23/10/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send(new User("1","2",new Random().nextInt(57)));
    }

}
