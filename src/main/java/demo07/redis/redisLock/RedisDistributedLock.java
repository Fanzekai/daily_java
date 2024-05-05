package demo07.redis.redisLock;
import redis.clients.jedis.Jedis;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  16:21
 */




public class RedisDistributedLock {

    private static final String LOCK_KEY = "my_lock";
    private static final String LOCK_VALUE = "locked";
    private static final int LOCK_EXPIRE_TIME = 30000; // 锁的过期时间，单位：毫秒

    private Jedis jedis;

    public RedisDistributedLock(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean tryLock() {
        // 尝试获取锁
        String result = jedis.set(LOCK_KEY, LOCK_VALUE, "NX", "PX", LOCK_EXPIRE_TIME);
        return "OK".equals(result);
    }

    public void unlock() {
        // 释放锁
        jedis.del(LOCK_KEY);
    }
}

