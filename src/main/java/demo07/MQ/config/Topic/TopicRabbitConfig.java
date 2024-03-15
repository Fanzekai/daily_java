package demo07.MQ.config.Topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/16  11:51
 */
@Component
public class TopicRabbitConfig implements BeanPostProcessor {




        @Bean
        public Queue topicExchangeQueueA() {
            //创建队列1
            return new Queue(RabbitMQConfigss.TOPIC_EXCHANGE_QUEUE_A, true, false, false);
        }

        @Bean
        public Queue topicExchangeQueueB() {
            //创建队列2
            return new Queue(RabbitMQConfigss.TOPIC_EXCHANGE_QUEUE_B, true, false, false);
        }

        @Bean
        public Queue topicExchangeQueueC() {
            //创建队列3
            return new Queue(RabbitMQConfigss.TOPIC_EXCHANGE_QUEUE_C, true, false, false);
        }

        @Bean
        public TopicExchange rabbitmqDemoTopicExchange() {
            //配置TopicExchange交换机
            TopicExchange topicExchange = new TopicExchange(RabbitMQConfigss.TOPIC_EXCHANGE_DEMO_NAME, true, false);
            return topicExchange;
        }

        @Bean
        public Binding bindTopicA() {
            //队列A绑定到FanoutExchange交换机
            return BindingBuilder.bind(topicExchangeQueueA())
                    .to(rabbitmqDemoTopicExchange())
                    .with("a.*");
        }

        @Bean
        public Binding bindTopicB() {
            //队列A绑定到FanoutExchange交换机
            return BindingBuilder.bind(topicExchangeQueueB())
                    .to(rabbitmqDemoTopicExchange())
                    .with("a.*");
        }

        @Bean
        public Binding bindTopicC() {
            //队列A绑定到FanoutExchange交换机
            return BindingBuilder.bind(topicExchangeQueueC())
                    .to(rabbitmqDemoTopicExchange())
                    .with("rabbit.#");
        }

//        @Override
//        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//            rabbitAdmin.declareExchange(rabbitmqDemoTopicExchange());
//            rabbitAdmin.declareQueue(topicExchangeQueueA());
//            rabbitAdmin.declareQueue(topicExchangeQueueB());
//            rabbitAdmin.declareQueue(topicExchangeQueueC());
//            return null;
//        }
    }

