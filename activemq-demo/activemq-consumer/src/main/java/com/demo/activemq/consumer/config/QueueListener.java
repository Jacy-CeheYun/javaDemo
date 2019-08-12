package com.demo.activemq.consumer.config;

import com.alibaba.fastjson.JSON;
import com.demo.activemq.consumer.mapper.UserMapper;
import com.demo.activemq.consumer.pojo.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author: elvin
 */
@Component
public class QueueListener {

    @Autowired
    private UserMapper userMapper;

    @JmsListener(destination = "publish.login", containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")
    public String receive(String text) {
        Username username = JSON.parseObject(text, Username.class);
        System.out.println(username);
        userMapper.insLogin(username);
        System.out.println("QueueListener: consumer-a 收到一条信息: " + text);
        return "consumer-a received : " + text;
    }
}