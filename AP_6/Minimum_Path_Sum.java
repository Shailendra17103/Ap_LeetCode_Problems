package Ap_LeetCode_Problems.AP_6;

public class Minimum_Path_Sum {

    int m(int grid[][],int dp[][],int i,int j)
    {
        if(i==grid.length-1 && j==grid[0].length-1)
        {
            return grid[i][j];
        }
        if(i>=grid.length || j>=grid[0].length)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int res=Integer.MAX_VALUE;
        int s=m(grid,dp,i,j+1);
        if(s!=Integer.MAX_VALUE)
        {
            res=s+grid[i][j];
        }
        s=m(grid,dp,i+1,j);
        if(s!=Integer.MAX_VALUE)
        {
            res=Math.min(res,s+grid[i][j]);
        }
        dp[i][j]=res;
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return m(grid,dp,0,0);
    }
}
