package Ap_LeetCode_Problems.AP_5;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        int index = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null; // Edge case: if root not found in inorder array (shouldn't normally happen)
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, index + 1),
            Arrays.copyOfRange(inorder, 0, index)
        );
        root.right = buildTree(
            Arrays.copyOfRange(preorder, index + 1, preorder.length),
            Arrays.copyOfRange(inorder, index + 1, inorder.length)
        );

        return root;
    }
}