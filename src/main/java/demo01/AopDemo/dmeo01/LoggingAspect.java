package demo01.AopDemo.dmeo01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  9:07
 */
@Aspect
public class LoggingAspect {

    // Before advice
    @Before("execution(* UserService.getUserById(..))")
    public void logBefore() {
        System.out.println("Before executing getUserById");
    }

    // After advice
    @After("execution(* UserService.getUserById(..))")
    public void logAfter() {
        System.out.println("After executing getUserById");
    }

    // Around advice
    @Around("execution(* UserService.getUserById(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before proceeding the method");
        Object result = joinPoint.proceed();
        System.out.println("After proceeding the method");
        return result;
    }
}

/*
* JoinPoint：通过pointcut选取出来的集合中的具体的一个执行点，我们就叫JoinPoint.

Advice：在选取出来的JoinPoint上要执行的操作、逻辑。关于５种类型，我不多说，不懂的同学自己补基础。

Aspect：就是我们关注点的模块化。这个关注点可能会横切多个对象和模块，事务管理是横切关注点的很好的例子。它是一个抽象的概念，从软件的角度来说是指在应用程序不同模块中的某一个领域或方面。又pointcut 和advice组成。

Weaving：把切面应用到目标对象来创建新的 advised 对象的过程


* */
