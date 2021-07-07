package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3805/">Kth Smallest Element in a Sorted Matrix</a>
 * <p>
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order,
 * return the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 */
public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(matrix[i][j]);
                } else {
                    if (matrix[i][j] < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.offer(matrix[i][j]);
                    }
                }
            }
        }
        return maxHeap.peek();
    }
}
