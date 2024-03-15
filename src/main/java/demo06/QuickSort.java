package demo06;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/26  20:38
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 8, 3, 2, 7, 6, 4};
        for (int i : arr) {
            System.out.println(i);
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        printArray(arr);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 将数组分区，并获取中轴元素的索引
            quickSort(arr, low, pivotIndex - 1); // 对中轴元素左边的子数组进行快速排序
            quickSort(arr, pivotIndex + 1, high); // 对中轴元素右边的子数组进行快速排序
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选取最右边的元素作为中轴元素
        int i = low - 1; // 初始化一个索引用于跟踪小于中轴元素的元素位置
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // 将小于中轴元素的元素交换到左侧
            }
        }
        swap(arr, i + 1, high); // 将中轴元素放置在正确的位置
        return i + 1; // 返回中轴元素的索引
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
