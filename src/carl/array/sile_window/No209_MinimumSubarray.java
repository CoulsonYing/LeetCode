package carl.array.sile_window;

public class No209_MinimumSubarray {
    public static void main(String[] args){
        int[] nums = new int[]{1,4,4};
        int target = 4;
        int len = minSubArrayLen2(target, nums);
        System.out.println(len);
    }

    public static int minSubArrayLen1(int target, int[] nums){
        int minLen = Integer.MAX_VALUE;     // 记录最短长度
        int sum = 0;    // 记录子数组的总和
        int left = 0, right = 0;

        while(right < nums.length){
            // 当sum<target时，一直加
            if((sum + nums[right]) < target){
                sum += nums[right++];
            }else{
                int len = right - left + 1;
                minLen = minLen > len ? len : minLen;
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static int minSubArrayLen2(int target, int[] nums){
        int minLen = Integer.MAX_VALUE;     // 记录最短长度
        int sum = 0;    // 记录子数组的总和
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            // 当sum<target时，记录left到right的元素总和sum
            if(sum < target){
                sum += nums[right];
            }
            // 当sum>=target时，记录长度，并left向前移，直至sum<target为止
            while(sum >= target){
                int len = right - left + 1;
                minLen = minLen > len ? len : minLen;
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
