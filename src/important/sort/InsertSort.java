package important.sort;

/**
 * 稳定的排序,空间复杂度O(1),时间复杂度O(n^2),最好情况O(1)
 * Created by liyajin on 16/8/4.
 */
public class InsertSort {

    private int[] sort(int[] nums){
        if(nums == null || nums.length < 1) return null;

        //第一个元素是有序的,从第二个元素开始插入到前面的有序序列中
        for(int i = 1; i < nums.length; i++){
            int insertNum = nums[i];
            int j;
            for(j = i - 1; j >= 0 && nums[j] > insertNum; j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = insertNum;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {8, 6, 4, 9, 2};
        InsertSort insertSort = new InsertSort();
        int[] result = insertSort.sort(nums);
        for (int i: result) {
            System.out.println(i);
        }
    }

}
