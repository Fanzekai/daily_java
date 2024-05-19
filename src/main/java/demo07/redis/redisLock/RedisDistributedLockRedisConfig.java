package demo07.redis.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/5  13:10
 */
@Component
public class RedisDistributedLockRedis01 {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String LOCK_KEY = "distributed_lock";
    private static final long LOCK_EXPIRE_TIME = 10000; // 锁的过期时间，单位：毫秒

    public boolean acquireLock(String value) {
        // 尝试设置键值对，如果键不存在则设置成功，获取锁成功
        return redisTemplate.opsForValue().setIfAbsent(LOCK_KEY, value, LOCK_EXPIRE_TIME, TimeUnit.MILLISECONDS);
    }

    public void releaseLock(String value) {
        // 释放锁，删除键
        redisTemplate.delete(LOCK_KEY);
    }
}
