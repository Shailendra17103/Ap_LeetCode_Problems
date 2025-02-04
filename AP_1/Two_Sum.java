package Ap_LeetCode_Problems.AP_1;

import java.util.HashMap;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (mp.containsKey(comp)) {
                return new int[] { 
                    mp.get(comp), i };
            }
            mp.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
}
