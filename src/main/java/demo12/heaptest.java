package demo12;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/6  19:08
 */
public class heaptest {

    public static void main(String[] args) {

        System.out.println("-------------======= 华丽的分割线 =========----------");
        //返回Java虚拟机中的堆内存总量
        long xmsMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //返回Java虚拟机中使用的最大堆内存
        long xmxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("-Xms:" + xmsMemory + "M");
        System.out.println("-Xmx:" + xmxMemory + "M");
//        System.out.println("系统内存大小为:" + xmsMemory * 64.0 / 1024 + "G");
//        System.out.println("系统内存大小为:" + xmxMemory * 4.0 / 1024 + "G");
//        在使用 -Xms500m -Xmx500m -XX:+PrintGCDetails需要把等待时间代码注释掉
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
