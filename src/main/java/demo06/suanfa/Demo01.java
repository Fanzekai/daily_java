package demo06.suanfa;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  9:49
 */

/*二分查找 非递归**/
public class Demo01 {

    public static void main(String[] args) {
        int []arr = {1,3,4,6,7,9};
        System.out.println(binarySearch(arr, 7));
    }
    //二分查找 非递归
    public static int binarySearch(int []arr,int target){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = (right-left)/2+left;
            if (target==arr[mid]){
                return mid;
            }else if(target>arr[mid]){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
}
