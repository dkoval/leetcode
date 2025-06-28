package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/">Find Subsequence of Length K With the Largest Sum</a>
 * <p>
 * You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.
 * <p>
 * Return any such subsequence as an integer array of length k.
 * <p>
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>-10^5 <= nums[i] <= 10^5</li>
 *  <li>1 <= k <= nums.length</li>
 * </ul>
 */
public interface FindSubsequenceOfLengthKWithTheLargestSum {

    int[] maxSubsequence(int[] nums, int k);

    class FindSubsequenceOfLengthKWithTheLargestSumRev1 implements FindSubsequenceOfLengthKWithTheLargestSum {

        @Override
        public int[] maxSubsequence(int[] nums, int k) {
            final var n = nums.length;

            final var minHeap = new PriorityQueue<IndexedValue>(Comparator.comparingInt(it -> it.value));
            for (var i = 0; i < n; i++) {
                minHeap.offer(new IndexedValue(i, nums[i]));
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            final var subseq = new ArrayList<>(minHeap);
            subseq.sort(Comparator.comparingInt(it -> it.index));

            final var ans = new int[k];
            var i = 0;
            for (var element : subseq) {
                ans[i++] = element.value;
            }
            return ans;
        }

        record IndexedValue(int index, int value) {
        }
    }

    class FindSubsequenceOfLengthKWithTheLargestSumRev2 implements FindSubsequenceOfLengthKWithTheLargestSum {

        @Override
        public int[] maxSubsequence(int[] nums, int k) {
            final var n = nums.length;

            // find the indices of the k largest elements in nums
            final var indices = new Integer[n];
            for (var i = 0; i < n; i++) {
                indices[i] = i;
            }
            Arrays.sort(indices, (i, j) -> Integer.compare(nums[j], nums[i]));

            // sort the indices of the k largest elements in ascending order
            Arrays.sort(indices, 0, k);

            // build the result
            final var ans = new int[k];
            for (var i = 0; i < k; i++) {
                ans[i] = nums[indices[i]];
            }
            return ans;
        }
    }
}
