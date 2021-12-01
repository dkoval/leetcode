package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public interface KthSmallestNumberInMultiplicationTable {

    class KthSmallestNumberInMultiplicationTableMemoryLimitExceeded implements KthSmallestNumberInMultiplicationTable {

        public int findKthNumber(int m, int n, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    maxHeap.offer(i * j);
                    if (maxHeap.size() > k) {
                        maxHeap.poll();
                    }
                }
            }
            return maxHeap.isEmpty() ? -1 : maxHeap.poll();
        }
    }
}
