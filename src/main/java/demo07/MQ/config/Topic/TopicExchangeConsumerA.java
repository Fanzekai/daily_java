package demo07.MQ.config.Topic;

import demo07.MQ.pojo.User;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/16  14:08
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfigss.TOPIC_EXCHANGE_QUEUE_A))
public class TopicExchangeConsumerA {

    @RabbitHandler
    public void process(User user) {
        System.out.println("队列[" + RabbitMQConfigss.TOPIC_EXCHANGE_QUEUE_A + "]收到消息：" + user.toString());
    }
}

