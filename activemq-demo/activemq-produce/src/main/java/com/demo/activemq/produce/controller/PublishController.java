package com.demo.activemq.produce.controller;

import com.demo.activemq.produce.pojo.Username;
import com.demo.activemq.produce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author: Jacy
 */
@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(Username username) {
        return loginService.login(username);
    }

    @JmsListener(destination = "out.queue")
    public void consumerMsg(String msg) {
        System.out.println(msg);
    }

    @RequestMapping("/topic")
    public String topic() {

        for (int i = 0; i < 10; i++) {
            jms.convertAndSend(topic, "topic" + i);
        }

        return "topic 发送成功";
    }
}