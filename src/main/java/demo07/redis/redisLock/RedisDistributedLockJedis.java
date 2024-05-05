package demo07.redis.redisLock;
import redis.clients.jedis.Jedis;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  16:34
 */

/**
 *使用redis实现分布式锁
 * 当模拟多个节点获取资源时，可以通过多线程的方式来模拟多个节点。其中一些线程会成功获取锁，而其他线程会获取失败
 * **/
public class RedisDistributedLockJedis {

    //private static final String LOCK_KEY = "my_lock";
    //private static final String LOCK_VALUE = "locked";
    //private static final int LOCK_EXPIRE_TIME = 300000; // 锁的过期时间，单位：毫秒

    public static void main(String[] args) {
        // 创建多个线程模拟多个节点
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Worker(i));
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final int id;

        public Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            Jedis jedis = new Jedis("localhost", 6379);
            RedisDistributedLock lock = new RedisDistributedLock(jedis);

            if (lock.tryLock()) {
                try {
                    System.out.println("Thread " + id + " acquired the lock.");
                    // 模拟执行业务逻辑
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("Thread " + id + " released the lock.");
                }
            } else {
                System.out.println("Thread " + id + " failed to acquire the lock.");
            }
        }
    }
}
