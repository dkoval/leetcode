package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">Kth Smallest Element in a Sorted Matrix</a>
 * <p>
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order,
 * return the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == matrix.length == matrix[i].length</li>
 *  <li>1 <= n <= 300</li>
 *  <li>-10^9 <= matrix[i][j] <= 10^9</li>
 *  <li>All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order</li>
 *  <li>1 <= k <= n^2</li>
 * </ul>
 */
public interface KthSmallestElementInSortedMatrix {

    int kthSmallest(int[][] matrix, int k);

    class KthSmallestElementInSortedMatrixUsingMaxHeap implements KthSmallestElementInSortedMatrix {

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

    class KthSmallestElementInSortedMatrixUsingBinarySearch implements KthSmallestElementInSortedMatrix {

        @Override
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;

            // Constraints say:
            // >> All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order
            int left = matrix[0][0];          // the smallest element in the matrix
            int right = matrix[n - 1][n - 1]; // the largest element in the matrix
            while (left < right) {
                // condition: the number of elements which are <= target is >= k
                // FF...FTT...T
                //       ^ answer
                int mid = left + (right - left) / 2;
                if (count(matrix, mid) >= k) {
                    // mid is the possible answer;
                    // check if there is a better option to the left of mid
                    right = mid;
                } else {
                    // mid and everything to the left of it is not the answer
                    left = mid + 1;
                }
            }
            return left;
        }

        private int count(int[][] matrix, int target) {
            // [ 1,  5,  9]
            // [10, 11, 13]
            // [12, 13, 15]
            int n = matrix.length;
            int count = 0;
            int i = n - 1;
            int j = 0;
            // scan left to right and bottom to top
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= target) {
                    count += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            return count;
        }
    }
}
