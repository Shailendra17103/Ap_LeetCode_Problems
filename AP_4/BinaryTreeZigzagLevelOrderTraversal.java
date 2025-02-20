package Ap_LeetCode_Problems.AP_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        int lvl = 1;
        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            List<Integer> lvlItems = new ArrayList<>();
            for (int i = 0; i < levelWidth; i++) {
                TreeNode node = queue.poll();
                if (lvl % 2 == 0) {
                    lvlItems.addFirst(node.val); 
                } else {
                    lvlItems.addLast(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
            result.add(lvlItems);
            lvl++;

        }
        return result;
    }
}
