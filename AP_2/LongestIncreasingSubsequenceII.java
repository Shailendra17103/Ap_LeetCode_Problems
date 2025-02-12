package Ap_LeetCode_Problems.AP_2;

public class LongestIncreasingSubsequenceII {
    public int lengthOfLIS(int[] nums, int k) {
        SegmentTree root = new SegmentTree(1, 100000);
        int res = 0;
        for (int num : nums) {
            int preMax = root.rangeMaxQuery(root, num - k, num - 1);
            root.update(root, num, preMax + 1);
            res = Math.max(res, preMax + 1);
        }
        return res;
    }
}

class SegmentTree {
    SegmentTree left, right;
    int start, end, val;
    public SegmentTree(int start, int end) {
        this.start = start;
        this.end = end;
        setup(this, start, end);
    }
    public void setup(SegmentTree node, int start, int end) {
        if (start == end) return;
        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new SegmentTree(start, mid);
            node.right = new SegmentTree(mid + 1, end);
        }
        setup(node.left, start, mid);
        setup(node.right, mid + 1, end);
        node.val = Math.max(node.left.val, node.right.val);
    }
    
    public void update(SegmentTree node, int index, int val) {
        if (index < node.start || index > node.end) return;
        if (node.start == node.end && node.start == index) {
            node.val = val;
            return;
        }
        update(node.left, index, val);
        update(node.right, index, val);
        node.val = Math.max(node.left.val, node.right.val);
    }
    
    public int rangeMaxQuery(SegmentTree node, int start, int end) {
        if (node.start > end || node.end < start) return 0;
        if (node.start >= start && node.end <= end) return node.val;
        return Math.max(rangeMaxQuery(node.left, start, end), rangeMaxQuery(node.right, start, end));
    }
    
}
