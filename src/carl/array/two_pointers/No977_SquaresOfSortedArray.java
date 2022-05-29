package carl.array.two_pointers;

import java.util.*;

public class No977_SquaresOfSortedArray {
    public static void main(String[] args){
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortedSquares(int[] nums){
        int len = nums.length;
        int[] result = new int[len];

        int left = 0, right = len - 1;
        for(int i = len - 1; i >= 0; i--){
            int num1 = nums[left] * nums[left];
            int num2 = nums[right] * nums[right];
            if(num1 > num2){
                result[i] = num1;
                left++;
            }else{
                result[i] = num2;
                right--;
            }
        }
        return result;
    }
}
