package carl.array.binary_search;

import java.util.*;

public class No34_FindFirstAndLast{
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10,10};
        int target = 10;
        int[] result = searchRange2(nums, target);
        System.out.println(Arrays.toString(result));
    }

    // 暴力法
    public static int[] searchRange1(int[] nums, int target){
        int[] result = new int[]{-1, -1};
        // 如果数组为空 或 目标值不在数组的范围内，则直接返回
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return result;
        // 遍历数组，寻找目标值
        for(int i = 0; i < nums.length; i++){
            // 找到目标值，
            if(nums[i] == target){
                // 判断左边界是否存在
                if(result[0] == -1) result[0] = i;
                if(result[1] == -1 || nums[i] == nums[i-1]) result[1] = i;
            }
        }
        return result;
    }

    // 二分查找法
    public static int[] searchRange2(int[] nums, int target){
        int[] result = new int[]{-1 ,-1};
        if(nums == null || nums.length == 0 || target < nums[0] || nums[nums.length - 1] < target)
            return result;
        // 1. 寻找左边界
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                result[0] = mid;
                right = mid - 1;
            }
        }
        // 2. 寻找右边界
        left = 0; right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                result[1] = mid;
                left = mid + 1;
            }
        }
        return result;
    }


}