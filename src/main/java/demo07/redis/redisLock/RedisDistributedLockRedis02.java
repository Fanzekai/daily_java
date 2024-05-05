package demo07.redis.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/5  13:19
 */
@Component
public class RedisDistributedLockRedis02 {


    @Autowired
    private RedisDistributedLockRedis01 distributedLock;

    public static void main(String[] args) {

    }

    public void someMethod() {
        try {
            if (distributedLock.acquireLock("lock_value")) {
                // 获取锁成功，执行业务逻辑
                // ...
            } else {
                // 获取锁失败，处理失败逻辑
                // ...
            }
        } finally {
            // 释放锁
            distributedLock.releaseLock("lock_value");
        }
    }
}
