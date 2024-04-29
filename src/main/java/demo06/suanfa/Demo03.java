package demo06.suanfa;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  9:52
 */


/** 分治算法**/
public class Demo03 {

    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }
    public static void hanoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if (num==1){
            System.out.println("第1个盘" + a + "->" + c);
        }else {
            //若我们有n>=2情况 我们总是可以看做是两个盘 最下边的一个盘 上面的所有盘
            //1.先把最上面的所有盘A->B 移动
            hanoiTower(num-1,a,c,b);
            //2.把最下面的盘 A->C
            System.out.println("第" + num + "个盘"+a +"->"+ c);
            //3.把B所有盘 B->C
            hanoiTower(num-1,b,a,c);
        }
    }
}
