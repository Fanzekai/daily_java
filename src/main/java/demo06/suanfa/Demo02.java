package demo06.suanfa;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  9:51
 */


/*递归二分查

* */
public class Demo02 {
    public static void main(String[] args) {
        int []arr = {1,3,4,7,8,9,22};
        int left = 0;
        int right = arr.length-1;
        int findValue=3;
        int i = binarySearch(arr, left, right, findValue);
        System.out.println(i);
    }

    private static int binarySearch(int[] arr, int left, int right, int findValue) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (left>right)
            return -1;
        if (findValue > midValue) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return binarySearch(arr, 0, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
