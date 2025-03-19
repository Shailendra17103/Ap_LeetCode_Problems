package Ap_LeetCode_Problems.AP_6;

import java.util.Arrays;

public class WaysToTileFloor {
       static int numberOfWays(int n) {
        // code here
        int [] dp=new int[n];
        Arrays.fill(dp,-1);
        if(n==1)
        {
            return 1;
        }
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
    
