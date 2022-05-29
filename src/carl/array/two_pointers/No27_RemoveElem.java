package carl.array.two_pointers;

public class No27_RemoveElem {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int result = removeElement2(nums, val);
        System.out.println(result);

    }

    public static int removeElement1(int[] nums, int val){
        if(nums.length == 0) return 0;

        int left = -1;
        for (int right = 0; right < nums.length; right++) {
            // 出现目标值时
            if(nums[right] == val)
                continue;
            // 出现非目标值时
            nums[++left] = nums[right];
        }
        return left+1;
    }

    public static int removeElement2(int[] nums, int val){
        if(nums.length == 0) return 0;

        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == val)
                continue;

            nums[left++] = nums[right];
        }
        return left;
    }
}
