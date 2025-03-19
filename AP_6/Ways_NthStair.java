package Ap_LeetCode_Problems.AP_6;

public class Ways_NthStair {
    int countWays(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }
}
    

