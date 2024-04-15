package demo02.kuangshen.threadJUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  14:52
 */
public class threadCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException, ExecutionException {
        //发起一个请求,没有返回值得异步回调
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"run");
        });
        System.out.println("1111");
        //获取阻塞执行结果
        completableFuture.get();


        //有返回值的异步回调
        //ajax,成功和失败回调
        //返回的是错误信息
    //    CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
    //        System.out.println("completableFuture"+Thread.currentThread().getName());
    //        int i = 10/0;
    //        return 1024;
    //    });
    //
    //    System.out.println(
    //            completableFuture.whenComplete((t, u) -> {
    //        System.out.println(t);//正常的返回结果
    //        System.out.println(u);//错误信息java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
    //    }).exceptionally((e) -> {
    //        System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
    //        return 233;
    //    }).get());
    }

}
