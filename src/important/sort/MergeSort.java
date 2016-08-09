package important.sort;

/**
 * 分而治之的思想,对一个数组进行排序,先把这个数组分成两边,分别对左边和右边进行排序,然后合并
 * 稳定的排序,空间复杂度O(n),时间复杂度O(nlogn),最好最坏情况都是O(nlogn)
 *
 * Created by liyajin on 16/8/4.
 * Created by liyajin on 16/8/9.
 */
public class MergeSort {

    private void merge(int[] nums, int start, int mid, int end){
        int[] temp = new int[nums.length];
        int index = start;
        int left = start;
        int right = mid + 1;

        while(left <= mid && right <= end){
            while(left <= mid && nums[left] <= nums[right])
                temp[index++] = nums[left++];

            while(right <= end && nums[right] < nums[left])
                temp[index++] = nums[right++];
        }

        while(left <= mid)
            temp[index++] = nums[left++];

        while(right <= end)
            temp[index++] = nums[right++];

        for(int i = start; i <= end; i++) nums[i] = temp[i];

    }

    private void mergeSort(int[] nums, int start, int end){
        if(start < end){
            int mid = (end - start) / 2 + start;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = {8, 6, 4, 8, 7, 8, 9, 2};
        mergeSort.mergeSort(nums, 0, nums.length - 1);
        for (int i: nums) {
            System.out.println(i);
        }
    }

}
