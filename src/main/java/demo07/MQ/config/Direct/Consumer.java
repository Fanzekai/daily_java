package demo07.MQ.config.Direct;


import demo07.MQ.pojo.User;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/15  16:01
 */
@Component
public class Consumer {


    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC))
    public void process1(User user) {

        System.out.println("消费者消费消息111=====" + user.getName()+user.getPassword());

    }



//    @RabbitHandler
//    @RabbitListener(queuesToDeclare = @Queue("queue_header02"))
//    public void sendMsgByDirectExchange(String message2) {
//
//        System.out.println("消费者消费消息111=====" + message2);

    }





