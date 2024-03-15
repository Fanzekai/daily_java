package demo07.MQ.config.Topic;

import demo07.MQ.pojo.Student;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/16  14:10
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfigss.TOPIC_EXCHANGE_QUEUE_C))
public class TopicExchangeConsumerC {

    @RabbitHandler
    public void process(Student student) {
        System.out.println("队列[" + RabbitMQConfigss.TOPIC_EXCHANGE_QUEUE_C + "]收到消息：" + student.toString());
    }
}
