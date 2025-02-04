package Ap_LeetCode_Problems.AP_1;

public class Move_Zeroes {
    
    public void moveZeroes(int[] nums){
        int left=0;
        if(nums.length==1){
            return;
        }
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
            }
        
    }
    for(int i=left;i<nums.length;i++){
        nums[i]=0;
    }

        
    }
}
