package Ap_LeetCode_Problems.AP_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        return String.join(",", list);  
    }

    private void helper(TreeNode node, List<String> strings) {
        if (node == null) {
            strings.add("null");
            return;
        }
        strings.add(String.valueOf(node.val));
        helper(node.left, strings);
        helper(node.right, strings);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper2(queue);
    }
    private TreeNode helper2(Queue<String> queue) {
        if (queue.isEmpty()){

        return null;
    }
        String val = queue.poll(); 
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(queue);
        node.right = helper2(queue);
        return node;
    }
    
}
