package com.demo.activemq.produce.service.impl;

import com.alibaba.fastjson.JSON;
import com.demo.activemq.produce.pojo.Username;
import com.demo.activemq.produce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Override
    public String login(Username username) {

        String userInfo = JSON.toJSONString(username);
        jms.convertAndSend(queue, userInfo);
        return null;
    }
}
