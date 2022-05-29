public class demo {
    public static void main(String[] args) {
        int nCount = 2;
        int mCount = 1;
        int[] nums = new int[]{83,800};
        int i = func(nCount, mCount, nums);
        System.out.println(i);
    }

    public static int func(int nCount, int mCount, int[] nums){
        if(nCount <= mCount || nCount < 1) return 10000;
        // 当出错次数>纠正次数时
        // 用数组记录每段的长度
        int[] lens = new int[nCount+1];
        lens[0] = nums[0] - 1;
        for(int i = 1; i < nums.length; i++){
            lens[i] = nums[i] - nums[i-1] - 1;
        }
        lens[nums.length] = 10000 - nums[nums.length-1];

        int maxLen = Integer.MIN_VALUE;
        // 计算最长成功批次
        int left = 0;
        int len = 0;
        for(int right = 0; right < lens.length; right++){
            if(right <= mCount){
                len += lens[right];
                maxLen = Math.max(maxLen,len);
                continue;
            }
            // 移动左右边界
            len = len - lens[left++] + lens[right];
            maxLen = Math.max(maxLen,len);
        }

        return maxLen + mCount;
    }
}
