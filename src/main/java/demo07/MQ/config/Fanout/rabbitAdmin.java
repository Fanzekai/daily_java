package demo07.MQ.config.Fanout;//package com.example.mqtest.config.Fanout;
//
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
///**
// * @author fzk
// * @version 1.0
// * @date 2023/11/16  10:44
// */
//@Component
//public class rabbitAdmin {
//
//
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        // rabbitmq 服务地址
//        connectionFactory.setAddresses("127.0.0.1");
//        // 用户名
//        connectionFactory.setUsername("guest");
//        // 密码
//        connectionFactory.setPassword("guest");
//        // 虚拟机路径
//        connectionFactory.setVirtualHost("/");
//
//        return connectionFactory;
//    }
//
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        // 只有设置为 true，spring 才会加载 RabbitAdmin 这个类
//        rabbitAdmin.setAutoStartup(true);
//        return rabbitAdmin;
//    }
//
//}
