package demo07.redis.redisLock;
import redis.clients.jedis.Jedis;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  16:21
 */




public class RedisDistributedLockJedis01 {

    private static final String LOCK_KEY = "my_lock";
    private static final String LOCK_VALUE = "locked";
    private static final int LOCK_EXPIRE_TIME = 30000; // 锁的过期时间，单位：毫秒

    private Jedis jedis;

    public RedisDistributedLockJedis01(Jedis jedis) {
        this.jedis = jedis;
    }

    //NX 代表只在 lock_key 不存在时，才对 lock_key 进行设置操作；
    //PX 10000 表示设置 Propagationlock_key 的过期时间为 10s，这是为了避免客户端发生异常而无法释放锁。
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

