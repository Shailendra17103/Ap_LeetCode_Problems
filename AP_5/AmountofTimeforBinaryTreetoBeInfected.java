package Ap_LeetCode_Problems.AP_5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AmountofTimeforBinaryTreetoBeInfected {
    private Map<Integer,List<Integer>> adjList=new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        conToGraph(root);
        Deque<Integer> que=new ArrayDeque<>();
        Set<Integer> vis=new HashSet<>();

        que.offer(start);
        int time=-1;

        while(!que.isEmpty()){
            time++;
            for(int i=que.size();i>0;i--){
                int currNode=que.pollFirst();
                vis.add(currNode);

                if(adjList.containsKey(currNode)){
                    for(int neighbor:adjList.get(currNode)){
                        if(!vis.contains(neighbor)){
                            que.offer(neighbor);
                        }
                    }
                }
            }
        }
        return time;
        
    }
    private void conToGraph(TreeNode node){
        if(node==null){
            return;
        }
        if(node.left!=null){
            adjList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
            adjList.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
        }
      
        if (node.right != null) {
            adjList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
            adjList.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
        }
      
        
        conToGraph(node.left);
        conToGraph(node.right);
    }

    
}
