package demo07.MQ.config.Fanout;

import demo07.MQ.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/16  10:23
 */
@Component
public class FanoutProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsgByFanoutExchange() {

        User user1 = new User();
        user1.setName("范泽楷");
        user1.setPassword("123456");
        System.out.println("生产者产生消息====="+user1);


//        Student student = new Student();
//        student.setName("陈泽楠");
//        student.setPassword("654321");
//        System.out.println("生产者产生消息====="+student);

        rabbitTemplate.convertAndSend(RabbitMQConfigs.FANOUT_EXCHANGE_DEMO_NAME, "", user1);
//        rabbitTemplate.convertAndSend(RabbitMQConfigs.FANOUT_EXCHANGE_DEMO_NAME, "", user1);


}}
