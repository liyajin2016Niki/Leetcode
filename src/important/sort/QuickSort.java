package important.sort;

/**
 * 测试:从左到右找到第一个大于base的,从右到左找到第一个小于base的,循环直到相遇
 * 不稳定
 * Created by liyajin on 16/7/29.
 */
public class QuickSort {

    public int[] quickSort(int[] nums, int start, int end){
        if(start >= end) return nums;
        int base = nums[start];
        int index = start;
        int left = index + 1;
        int right = end;

        while(left < right){
            while(left < right && nums[right] > base) right--;
            nums[index] = nums[right];
            index = right;
            while(left < right && nums[left] < base) left++;
            nums[index] = nums[left];
            index = left;

            nums[index] = base;
        }


        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {8,4,6,1};
        QuickSort qs = new QuickSort();
        int[] result = qs.quickSort(nums, 0, nums.length-1);
        for (int i:result) {
            System.out.println(i);
        }
    }
}
