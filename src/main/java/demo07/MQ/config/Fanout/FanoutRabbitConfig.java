package demo07.MQ.config.Fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/15  19:59
 */
@Configuration
public class FanoutRabbitConfig implements BeanPostProcessor {

//    @Resource
//    private RabbitAdmin rabbitAdmin;

    @Bean
    public Queue fanoutQueueA() {
        //队列A
        return new Queue(RabbitMQConfigs.FANOUT_EXCHANGE_QUEUE_TOPIC_A, true, false, false);
    }

    @Bean
    public Queue fanoutQueueB() {
        //队列B
        return new Queue(RabbitMQConfigs.FANOUT_EXCHANGE_QUEUE_TOPIC_B, true, false, false);
    }

    @Bean
    public FanoutExchange MQDemoFanoutExchange() {
        //创建FanoutExchange类型交换机
        return new FanoutExchange(RabbitMQConfigs.FANOUT_EXCHANGE_DEMO_NAME, true, false);
    }

    @Bean
    public Binding bindFanoutA() {
        //队列A绑定到FanoutExchange交换机
        return BindingBuilder
                .bind(fanoutQueueA())
                .to(MQDemoFanoutExchange());
    }

    @Bean
    public Binding bindFanoutB() {
        //队列B绑定到FanoutExchange交换机
        return BindingBuilder
                .bind(fanoutQueueB())
                .to(MQDemoFanoutExchange());
    }

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//
//
//        //启动项目即创建交换机和队列
//        rabbitAdmin.declareExchange(MQDemoFanoutExchange());
//        rabbitAdmin.declareQueue(fanoutQueueA());
//        rabbitAdmin.declareQueue(fanoutQueueB());
//        return null;
//    }


}
