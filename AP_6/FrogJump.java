package Ap_LeetCode_Problems.AP_6;
class FrogJump {
    int minCost(int[] height) {
        int len = height.length;
        
        if (len==1) {
            return 0;
        }
        
        if (len==2) {
            return Math.abs(height[1]-height[0]);
        }
        
        int first = 0;
        int second = Math.abs(height[1]-height[0]);
        int cost = 0;
        
        for (int i=2; i<len; i++) {
            int firstPair = Math.abs(height[i]-height[i-2]);
            int secondPair = Math.abs(height[i]-height[i-1]);
            cost = Math.min(first+firstPair, 
                    second+secondPair);
            first = second;
            second = cost;
        }
        
        return cost;
    }
}
