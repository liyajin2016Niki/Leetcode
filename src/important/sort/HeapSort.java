package important.sort;

/**
 * 不稳定的排序,时间复杂度为O(nlogn)
 * 维护一个最大堆的时间复杂度O(logn),建立堆时有n/2次堆化操作
 * 排序时需要重新堆化n-1次
 * 不需要使用额外的空间
 * Created by liyajin on 16/8/17.
 */
public class HeapSort {

    //堆化操作,从index开始检查,并保持在heapSize内最大堆的性质
    public static void maxHeapify(int[] array, int index, int heapSize){
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        int max = array[index];
        int maxIndex = index;

        if(leftChild <= heapSize && max < array[leftChild]){
            max = array[leftChild];
            maxIndex = leftChild;
        }

        if(rightChild <= heapSize && max < array[rightChild]){
            max = array[rightChild];
            maxIndex = rightChild;
        }

        if(maxIndex != index){
            array[maxIndex] = array[index];
            array[index] = max;
            maxHeapify(array, maxIndex, heapSize);
        }

    }

    //创建最大堆
    public static void buildMaxHeap(int[] array){
        if(array == null || array.length < 2) return;

        for(int index = (array.length - 2)/2; index >= 0; index--){
            maxHeapify(array, index, array.length-1);
        }
    }

    //堆排序
    public static void heapSort(int[] array){
        //建最大堆
        buildMaxHeap(array);

        //此时array[0]为最大值,与最后一个值交换,再进行堆化操作,堆化的size除去最后一个放好的最大值,循环
        for(int i = array.length-1; i > 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            maxHeapify(array, 0, i-1);
        }


    }

    public static void main(String[] args) {
        int[] nums = {8, 6, 4, 9, 2, 9, 10, 1, 3, 7};
//        HeapSort.maxHeapify(nums, 0, nums.length-1);
//        HeapSort.buildMaxHeap(nums);
        HeapSort.heapSort(nums);
        for (int i:nums) {
            System.out.println(i);
        }
    }


}
