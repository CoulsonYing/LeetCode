package carl.array.two_pointers;

import java.util.*;

public class No283_MoveZero {
    public static void main(String[] args){
        int[] nums = new int[]{0};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros(int[] nums){
        int slow = 0;
        // fast遍历数组，将非0元素放置数组前端
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        // 利用slow，将数组剩余部分赋值为0
        for(int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
