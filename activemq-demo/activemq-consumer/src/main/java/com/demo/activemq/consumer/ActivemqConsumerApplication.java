package com.demo.activemq.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.activemq.consumer.mapper")
public class ActivemqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqConsumerApplication.class, args);
    }

}
