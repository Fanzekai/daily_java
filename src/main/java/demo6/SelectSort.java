package demo6;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/8/28  16:13
 */
public class SelectSort {
    public int[] sort(int arr[]) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
// 认为目前的数就是最小的, 记录最小数的下标
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
// 修改最小值的下标
                    minIndex = j;
                }
            }
// 当退出for就找到这次的最小值,就需要交换位置了
            if (i != minIndex) {
//交换当前值和找到的最小值的位置
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] array = {2,5,1,6,4,9,8,5,3,1,2,0};
        int[] sort = selectSort.sort(array);
        for (int num:sort){
            System.out.print(num+"\t");
        }
    }
}
