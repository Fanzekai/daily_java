package demo07.MQ.config.Topic;

import demo07.MQ.pojo.User;
import demo07.MQ.pojo.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/16  14:05
 */
@Component
public class TopicProducer {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsgByFanoutExchange() {

        User user1 = new User();
        user1.setName("范泽楷");
        user1.setPassword("123456");
        System.out.println("生产者产生消息====="+user1);


        Student student = new Student();
        student.setName("陈泽楠");
        student.setPassword("654321");
        System.out.println("生产者产生消息====="+student);

        rabbitTemplate.convertAndSend(RabbitMQConfigss.TOPIC_EXCHANGE_DEMO_NAME,"a.b", user1);
        rabbitTemplate.convertAndSend(RabbitMQConfigss.TOPIC_EXCHANGE_DEMO_NAME,"rabbit.a.b.c", student);


    }}

