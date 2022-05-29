package carl.array.sile_window;

import java.util.*;

public class No904_FruitBaskets {
    public static void main(String[] args){
        int[] fruits = new int[]{1,2,3,2,2};
        int len = totalFruit(fruits);
        System.out.println(len);
    }

    public static int totalFruit(int[] fruits){
        Map<Integer, Integer> baskets = new HashMap<Integer, Integer>();
        int maxLen = Integer.MIN_VALUE, len = 0;
        int left = 0;
        for(int right = 0; right < fruits.length; right++){
            // 当篮子中水果数量小于2时
            if(baskets.size() < 2){
                baskets.put(fruits[right], baskets.getOrDefault(fruits[right],0)+1);
                len++;
                maxLen = Math.max(maxLen, len);
                continue;
            }
            // 当篮子不包含nums[right]时
            if(!baskets.containsKey(fruits[right])){
                // 移动左边界
                while(!(baskets.size() < 2)){
                    baskets.put(fruits[left], baskets.get(fruits[left])-1);
                    len--;
                    if(baskets.get(fruits[left]) == 0){
                        baskets.remove(fruits[left]);
                    }
                    left++;
                }
                baskets.put(fruits[right], 1);
                len++;
            }else{
                baskets.put(fruits[right], baskets.get(fruits[right])+1);
                len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen == Integer.MIN_VALUE ? fruits.length : maxLen;
    }
}
