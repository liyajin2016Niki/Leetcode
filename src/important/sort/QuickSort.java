package important.sort;

/**
 * 不稳定的排序,时间复杂度O(nlogn),最坏情况就是基本有序情况下,退化为冒泡排序,O(n^2)
 * 空间复杂度:使用递归栈,平均O(logn),最坏O(n)
 * 优化:比较划分后两端数组的长度,先对短的一半进行排序,尽早释放栈空间
 * Created by liyajin on 16/8/15.
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }

    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];             //交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {8, 6, 4, 8, 7, 8, 9, 2};
        quickSort.quickSort(nums);
        for (int i: nums) {
            System.out.println(i);
        }
    }

}
