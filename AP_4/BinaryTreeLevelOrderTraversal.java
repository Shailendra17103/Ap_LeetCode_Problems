package Ap_LeetCode_Problems.AP_4;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        pre(root, 0, al);
        return al;
    }

    public static void pre(TreeNode root, int l, List<List<Integer>> al) {
        if (root == null) {
            return;
        }
        if (al.size() == l) {
            List<Integer> li = new ArrayList<>();
            li.add(root.val);
            al.add(li);
        } else {
            al.get(l).add(root.val);
        }
        pre(root.left, l + 1, al);
        pre(root.right, l + 1, al);
    }
}
