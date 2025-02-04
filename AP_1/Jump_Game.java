package Ap_LeetCode_Problems.AP_1;

public class Jump_Game {
    public boolean canJump(int[] nums) {
        
        int target=nums.length-1;

        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=target){
                target=i;
            }
        }
        return target==0;

        }
    
}
