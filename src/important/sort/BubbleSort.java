package important.sort;

/**
 * 稳定的排序,时间复杂度O(n^2),空间复杂度O(1),最好情况O(n)
 * 优化:如果一趟下来没有进行任何交换,说明已经有序了。
 * Created by liyajin on 16/8/4.
 */
public class BubbleSort {

    private int[] sort(int[] nums){
        if(nums == null || nums.length < 1) return null;
        for(int i = nums.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                //比较nums[j],nums[j+1],如果nums[j]大于nums[j+1]则交换
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {8, 6, 4, 9, 2};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(nums);
        for (int i: result) {
            System.out.println(i);
        }
    }
}
