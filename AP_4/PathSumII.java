package Ap_LeetCode_Problems.AP_4;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> li=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        dfs(root,0,targetSum,li,l);
        return li;
    }
    private void dfs(TreeNode root,int sum,int targetSum,List<List<Integer>> li,List<Integer> l){
        if(root==null){
            return ;
        }
        sum+=root.val;
        l.add(root.val);
        if(root.left==null && root.right==null && sum==targetSum){
            li.add(l);
        }
        dfs(root.left,sum,targetSum,li,new ArrayList<>(l));
        dfs(root.right,sum,targetSum,li,new ArrayList<>(l));
        return;
    }
}
