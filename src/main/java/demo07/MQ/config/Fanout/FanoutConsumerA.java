package demo07.MQ.config.Fanout;



import demo07.MQ.pojo.User;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/16  10:25
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfigs.FANOUT_EXCHANGE_QUEUE_TOPIC_A))
public class FanoutConsumerA {


        @RabbitHandler
        public void process1(User user1) {
            System.out.println("队列A收到消息：" + user1.toString());
        }



    }

