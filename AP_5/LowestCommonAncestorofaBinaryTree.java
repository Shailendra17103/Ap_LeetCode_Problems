package Ap_LeetCode_Problems.AP_5;

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
           return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }
        return left==null ? right:left;
    }
    
}
