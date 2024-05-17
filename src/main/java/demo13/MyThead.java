package demo13;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/15  20:19
 */


public class MyThead extends Thread{



public static void main(String[] args) {

    MyThead t = new MyThead();
    MyThead s = new MyThead();
    t.start();
    System.out.println("one.");
    s.start();
    System.out.println("two.");
}
        public void run(){
        System. out.println("Thread");
        }}
