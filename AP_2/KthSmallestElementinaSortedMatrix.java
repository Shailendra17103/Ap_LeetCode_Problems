package Ap_LeetCode_Problems.AP_2;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
    class MinHeapNode implements Comparable<MinHeapNode> {
        int value;
        int rowIndex;
        int colIndex;

        public MinHeapNode(int value, int rowIndex, int colIndex) {
            this.value = value;
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        @Override
        public int compareTo(MinHeapNode other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int rowCount = matrix.length;
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
        for (int i = 0; i < Math.min(rowCount, k); i++) {
            minHeap.offer(new MinHeapNode(matrix[i][0], i, 0));
        }

        int numbersChecked = 0, smallestElement = 0;

        while (!minHeap.isEmpty()) {
            MinHeapNode current = minHeap.poll();
            smallestElement = current.value;
            numbersChecked++;
            if (numbersChecked == k) break;
            if (current.colIndex + 1 < matrix[current.rowIndex].length) {
                minHeap.offer(new MinHeapNode(
                    matrix[current.rowIndex][current.colIndex + 1],
                    current.rowIndex,
                    current.colIndex + 1
                ));
            }
        }

        return smallestElement;
    }
    
}
