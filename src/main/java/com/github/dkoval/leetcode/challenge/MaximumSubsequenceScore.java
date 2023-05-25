package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-subsequence-score/">Maximum Subsequence Score</a>
 * <p>
 * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k.
 * You must choose a subsequence of indices from nums1 of length k.
 * <p>
 * For chosen indices i0, i1, ..., ik - 1, your score is defined as:
 * <ul>
 *  <li>The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.</li>
 *  <li>It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).</li>
 * </ul>
 * Return the maximum possible score.
 * <p>
 * A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums1.length == nums2.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>0 <= nums1[i], nums2[j] <= 10^5</li>
 *  <li>1 <= k <= n</li>
 * </ul>
 */
public interface MaximumSubsequenceScore {

    long maxScore(int[] nums1, int[] nums2, int k);

    class MaximumSubsequenceScoreRev1 implements MaximumSubsequenceScore {

        @Override
        public long maxScore(int[] nums1, int[] nums2, int k) {
            // idea: greedy - maximize the min among k elements in nums2[] + min heap to maximize the sum of k elements in nums1[]
            int n = nums2.length;

            // step #1: sort nums2 in DESC order while recording the original order of elements
            IndexedValue[] mins = new IndexedValue[n];
            for (int i = 0; i < n; i++) {
                mins[i] = new IndexedValue(i, nums2[i]);
            }
            Arrays.sort(mins, Comparator.<IndexedValue>comparingInt(it -> it.value).reversed());

            long best = 0;
            long sum = 0;
            Queue<Integer> minHeap = new PriorityQueue<>();
            for (IndexedValue min : mins) {
                int x = nums1[min.index];

                sum += x;
                minHeap.offer(x);
                if (minHeap.size() > k) {
                    sum -= minHeap.poll();
                }

                if (minHeap.size() == k) {
                    best = Math.max(best, sum * min.value);
                }
            }
            return best;
        }

        private static class IndexedValue {
            final int index;
            final int value;

            IndexedValue(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }
    }
}
