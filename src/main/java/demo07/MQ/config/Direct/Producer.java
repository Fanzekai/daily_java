package demo07.MQ.config.Direct;


import demo07.MQ.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/15  16:02
 */
@Component
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produce() {


        User user = new User();
        user.setName("范泽楷");
        user.setPassword("123456");
        System.out.println("生产者产生消息====="+user);


        //Direct Exchange类型
//        rabbitTemplate.convertAndSend("seckillQueue", user);
        rabbitTemplate.convertAndSend(RabbitMQConfig.RABBITMO_DEMO_DIRECT_EXCHANGE, RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING, user);




        //        String message1 = new Date() + "Beijing";
//        System.out.println("生产者产生消息=====" + message1);
//        rabbitTemplate.convertAndSend("seckillQueue", message1);
//
//        String message2="范泽楷";
//        System.out.println("生产者产生消息=====" + message2);
//        rabbitTemplate.convertAndSend("queue_header02",message2);
    }
}
