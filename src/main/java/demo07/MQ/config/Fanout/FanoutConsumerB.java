package demo07.MQ.config.Fanout;

import demo07.MQ.pojo.User;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/16  10:29
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfigs.FANOUT_EXCHANGE_QUEUE_TOPIC_B))
public class FanoutConsumerB {

    @RabbitHandler

    public void process2(User user1) {
        System.out.println("队列B收到消息：" + user1.toString());
    }
}
