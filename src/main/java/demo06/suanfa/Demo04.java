package demo06.suanfa;
import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  9:52
 */

/**
 *
 *动态规划算法
 * **/
public class Demo04 {

    public static void main(String[] args) {
        int []w = {1,4,3};//物品的重量
        int []price = {1500,3000,2000};//物品的价值 这里price[i]
        int m = 4;//背包的容量
        int n = price.length;//物品的个数

        //为了记录放入商品的情况 定义一个二二数组
        int [][]path = new int[n+1][m+1];

        //二维数组
        //v[i][j] 表示前i个物品中能够装入容量为j的背包中的最大价值
        int [][]v = new int[n+1][m+1];
        //初始化第一行和第一列为0  这里可以不用处理 因为默认是0
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j <v[0].length ; j++) {
                if(i==0||j==0){
                    v[i][j]=0;
                }else {
                    //公式
                    if(w[i-1]>j){//因为w的下标是0，1，2 而填表的时候第0列是0 第一列开始才是物品 所以需要减一
                        v[i][j]=v[i-1][j];
                    }else if(w[i-1]<=j){
                        /*
                        v[i][j]=Math.max(v[i-1][j],price[i-1]+v[i-1][j-w[i-1]]);
                        为了详细记录物品存放的情况 上述这个不能再用了 需使用if-else
                         */
                        if(v[i-1][j]<price[i-1]+v[i-1][j-w[i-1]]){
                            v[i][j]=price[i-1]+v[i-1][j-w[i-1]];
                            path[i][j]=1;
                        }else {
                            v[i][j]=v[i-1][j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        int i = path.length-1;//行的最大下标
        int j = path[0].length-1;//列的最大下标
        while (i>0&&j>0){
            if(path[i][j]==1){
                System.out.println("把第" + i + "个商品放入背包");
                j-=w[i-1];
            }
            i--;
        }
    }
}
