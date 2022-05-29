package carl.array.two_pointers;

public class No26_RemoveDuplicaties {
    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums){
        int len = nums.length;
        // 排除数组长度为0和1的情况
        if(len == 0 || len == 1) return len;

        int slow = 1;
        for(int fast = 1; fast < len; fast++){
            if(nums[fast] != nums[fast-1]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
