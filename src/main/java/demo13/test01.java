package demo13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/15  19:52
 */
public class test01 {

    public static void main(String[] args) {


        System.out.println("请输入");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int m = scanner.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {

            prices[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(prices);
        int count=0;
        for (int i = 0; i < n; i++) {

            if (prices[i]<m){
                count++;

            }else {
                break;
            }
        }
        System.out.println(count);










    }
}
