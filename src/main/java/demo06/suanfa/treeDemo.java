package demo06.suanfa;

import java.util.Arrays;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/11  21:30
 */
public class treeDemo {


    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return count;
    }

    //二分查找
    public static int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        //System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1,3}));


        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 4));
    }

}
