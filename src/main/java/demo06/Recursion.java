package demo06;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/8/28  16:11
 */
public class Recursion {
    //阶乘算法
    public int factorial(int num){
        if (num==0 || num== 1){
            return 1;
        }else{
            return num*factorial(num-1);
        }
    }
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        int n = 4;
        int factorial = recursion.factorial(n);
        System.out.println(factorial);
    }
}
