package Ap_LeetCode_Problems.AP_5;

public class FlattenBinaryTreetoLinkedList {
    public TreeNode prev = null;

     public void flatten(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode current=root;
        while(current!=null){
            if(current.left!=null){
              TreeNode temp=current.left;
              while(temp.right!=null){
                  temp=temp.right;
              }
              temp.right=current.right;
              current.right=current.left;
              current.left=null;
            }
            current=current.right;

        }
    }
    
}
