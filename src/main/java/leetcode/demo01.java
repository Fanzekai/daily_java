package leetcode;

import java.util.Arrays;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/22  11:39
 */
public class demo01 {


    /**
     * 主方法，用于测试寻找数组中位数索引的功能。
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        // 测试用例1: 奇数个数组
        int[] nums1 = {1, 7, 3, 6, 5, 6, 4};
        System.out.println("奇数个数组中位数索引: " + getMiddleNumber(nums1));

        // 测试用例2: 偶数个数组，存在中位数（两个数相等）
        int[] nums2 = {1, 7, 3, 6, 5, 6};
        System.out.println("偶数个数组中位数索引: " + getMiddleNumber(nums2));

        // 测试用例3: 偶数个数组，不存在中位数（两个数不相等，返回-1）
        int[] nums3 = {1, 2, 3, 4, 5, 6};
        System.out.println("不存在中位数索引: " + getMiddleNumber(nums3));
    }

    // 同时修正方法名拼写错误
    public static int getMiddleNumber(int[] nums) {
        int leftnum = 0;
        int sum = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) {
            if (sum - leftnum - nums[i] == leftnum) {
                return i;
            }
            leftnum += nums[i];
        }
        return -1;
    }
}
