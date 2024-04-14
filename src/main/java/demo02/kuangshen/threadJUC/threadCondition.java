package demo02.kuangshen.threadJUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:35
 */

/**
 * A->B->C,condition实现精准通知唤醒
 */
public class threadCondition {

    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        },"C").start();
    }
}
class Data3{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int num =1; //1A,2B,3C
    public void printA() {
        lock.lock();
        try {
            //业务,判断,执行,通知
            while (num != 1){
                condition1.await();
            }
            System.out.println("aaaaaaaaaaaa");
            //唤醒指定的人,B
            num =2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB() {
        lock.lock();
        try {
            while (num != 2){
                condition2.await();
            }
            System.out.println("bbbbbbbbbbbb");
            //唤醒指定的人,B
            num =3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC() {
        lock.lock();
        try {
            while (num != 3){
                condition3.await();
            }
            System.out.println("ccccccccccc");
            //唤醒指定的人,B
            num =1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

