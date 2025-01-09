package demo07.redis.redisLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/5  13:51
 */

//假设我们要限制每秒钟最多只能处理10个请求，可以使用Redis的INCR命令来实现计数器。
// 首先，我们需要在Redis中创建一个键来保存计数器的值，然后每当有请求到达时，就调用INCR命令将计数器的值加1，并检查当前值是否超过了限制。
public class RedisincrDemo {

    private static final String COUNTER_KEY = "request_counter";
    private static final int MAX_REQUESTS_PER_SECOND = 10;



    public static void main(String[] args) {
        // 模拟多个请求到达
        for (int i = 0; i < 15; i++) {
            new Thread(() -> {
                Jedis jedis = new Jedis("localhost", 6379);
                try {
                    long currentCount = jedis.incr(COUNTER_KEY);
                    System.out.println("Current request count: " + currentCount);
                    if (currentCount > MAX_REQUESTS_PER_SECOND) {
                        System.out.println("Rate limit exceeded!");
                    } else {
                        System.out.println("Processing request...");
                        // 模拟业务逻辑执行
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    jedis.close();
                }
            }).start();
        }
    }    }

