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

    /**
     * 在执行UserService的getUserById方法之前执行的通知。
     *
     * @return 无返回值
     */
    // Before advice
    @Before("execution(* UserService.getUserById(..))")
    public void logBefore() {
        System.out.println("Before executing getUserById");
    }

    /**
     * 这是一个切面（Aspect）中的通知（Advice），它使用了Spring AOP（面向切面编程）的功能。
     *
     * @After注解表明这是一个后置通知，它会在目标方法正常完成后执行。
     * @param "execution(* UserService.getUserById(..))" 指定了切点表达式，
     * 表示该通知将应用于UserService类中getUserById方法的执行。
     * 此处的*表示匹配任何返回类型，(..)表示匹配任何参数列表。
     *
     * 当UserService类中的getUserById方法正常执行完毕后，
     * 此方法（logAfter）将被调用，输出一条日志信息，表明getUserById方法已经执行完毕。
     */
    // After advice
    @After("execution(* UserService.getUserById(..))")
    public void logAfter() {
        System.out.println("After executing getUserById");
    }

    /**
     * 环绕通知（Around Advice）
     * 该通知方法会在目标方法执行前后进行拦截，允许在目标方法执行前后添加自定义逻辑。
     *
     * @param joinPoint 连接点对象，提供了对拦截方法的反射访问
     * @return 目标方法的执行结果
     * @throws Throwable 如果在通知方法或目标方法中抛出异常，该异常将被抛出
     */
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
