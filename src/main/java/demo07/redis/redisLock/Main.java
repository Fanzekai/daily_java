package demo07.redis.redisLock;
import redis.clients.jedis.Jedis;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  16:20
 */


public class Main {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        RedisDistributedLock lock = new RedisDistributedLock(jedis);

        // 尝试获取锁
        if (lock.tryLock()) {
            try {
                // 成功获取到锁，执行业务逻辑
                System.out.println("执行业务逻辑...");
                // 模拟业务逻辑执行时间
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                lock.unlock();
            }
        } else {
            System.out.println("获取锁失败，其他节点正在执行业务逻辑...");
        }
    }
}
