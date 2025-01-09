package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/22  21:54
 */
public class demo02 {


    public static int getNumber(int[] nums, int number) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=number ) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {

        int[] nums = {1,  3, 5, 6,9};
        System.out.println(getNumber(nums, 20));
    }
}
