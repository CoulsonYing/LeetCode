package carl.array.binary_search;

public class No35_SearchInsert{
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 7;
        int result = searchInsert2(nums, target);
        System.out.println(result);
    }

    public static int searchInsert1(int[] nums, int target){
        // 1. 判断target是否在已有的数组大小范围内。没有则直接返回
        if(target < nums[0]) return 0;
        if(target > nums[nums.length - 1]) return nums.length;
        // 2. target在数组范围内时
        // 2.1 寻找是否存在目标值
        int left = 0, right = nums.length - 1;
        // 利用左闭右闭的区间
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        // 2.2 目标值不在，则确定插入的位置
        int index = nums[mid] < target ? mid + 1 : mid;
        return index;
    }

    // 利用暴力法求解，依次比较
    public static int searchInsert2(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            // 如果target > nums[i]，继续下一个
            if(target > nums[i]){
                continue;
            }else{
                return i;
            }
        }
        return nums.length;
    }
}