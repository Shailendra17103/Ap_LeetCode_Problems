package Ap_LeetCode_Problems.AP_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> list = new ArrayList<>();
        
        List<int[]> lines = new ArrayList<>();
        for (int[] building: buildings) {
            lines.add(new int[] {building[0], building[2]});
            lines.add(new int[] {building[1], -building[2]});
        }
        Collections.sort(lines, (a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int prev=0;
        for (int[] line: lines) {
            if (line[1]>0) {
                map.put(line[1], map.getOrDefault(line[1], 0)+1);
            } else {
                int f = map.get(-line[1]);
                if (f==1) map.remove(-line[1]);
                else map.put(-line[1], f-1);
            }
            int curr = map.lastKey();
            if (curr!=prev) {
                list.add(Arrays.asList(line[0], curr));
                prev=curr;
            }
        }
        return list;
    }
    
}
