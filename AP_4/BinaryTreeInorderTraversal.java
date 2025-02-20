package Ap_LeetCode_Problems.AP_4;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorder(TreeNode root, List<Integer> list){
        if(root == null)return list;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);

        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> list = new ArrayList<Integer>();
       return inorder(root,list);

    }
}
