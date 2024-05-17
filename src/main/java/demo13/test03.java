package demo13;

import java.util.Map;
import java.util.Scanner;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/15  20:07
 */
public class test03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int z = scanner.nextInt();
        scanner.close();

        int diff_a= Math.abs(z-a);
        int diff_b= Math.abs(z-b);
        int diff_c= Math.abs(z-c);


        if (diff_a<diff_b&&diff_a<diff_c){
            System.out.println("A");
      }else if (diff_b<diff_a&&diff_b<diff_c){
            System.out.println("B");
        }else if (diff_c<diff_a&&diff_c<diff_b){
            System.out.println("C");
        }
        else {
            System.out.println("same");
        }

    }
}
