package carl.array.binary_search;

public class No704_BinarySearch{
    public static void main(String[] args){
        int[] nums = {-1,0,3,5,9,12};
        int target = 12;
        int result = search2(nums, target);
        System.out.println(result);
    }

    // 搜索区间左闭右闭：[left, right]
    public static int search1(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        if(target < nums[left] || nums[right] < target)
            return -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    // 搜索区间左闭右开：[left,right)
    public static int search2(int[] nums, int target){
        int left = 0, right = nums.length;
        if(target < nums[left] || nums[right - 1] < target)
            return -1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return -1;
    }

}