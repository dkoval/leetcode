package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3773/">Jump Game VI</a>
 * <p>
 * You are given a 0-indexed integer array nums and an integer k.
 * <p>
 * You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside
 * the boundaries of the array. That is, you can jump from index i to any index
 * in the range [i + 1, min(n - 1, i + k)] inclusive.
 * <p>
 * You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j]
 * for each index j you visited in the array.
 * <p>
 * Return the maximum score you can get.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length, k <= 10^5</li>
 *  <li>-10^4 <= nums[i] <= 10^4</li>
 */
public interface JumpGame6 {

    int maxResult(int[] nums, int k);

    // O(N * K) time | O(N) space
    class JumpGame6TTEOnLargeInput implements JumpGame6 {

        @Override
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            // dp[i] denotes max score at i-th index
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                int maxScoreSoFar = Integer.MIN_VALUE;
                for (int j = Math.max(0, i - k); j < i; j++) {
                    maxScoreSoFar = Math.max(maxScoreSoFar, dp[j]);
                }
                dp[i] = maxScoreSoFar + nums[i];
            }
            return dp[n - 1];
        }
    }

    // O(NlogN) time | O(N) space
    // Resource: https://medium.com/nerd-for-tech/day-9-jump-game-vi-1af20e1a74c
    class JumpGame6UsingMaxHeapAsSlidingWindow implements JumpGame6 {

        private static class IndexedValue {
            final int index;
            final int value;

            IndexedValue(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        @Override
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            // dp[i] denotes max score you can get when reaching index n - 1 from index i.
            // We're going to fill in dp[] iterating from right to left.
            int[] dp = new int[n];
            dp[n - 1] = nums[n - 1];

            // Sliding window of size <= k
            PriorityQueue<IndexedValue> maxHeap = new PriorityQueue<>((obj1, obj2) -> obj2.value - obj1.value);
            maxHeap.offer(new IndexedValue(n - 1, dp[n - 1]));

            for (int i = n - 2; i >= 0; i--) {
                IndexedValue x = maxHeap.peek();
                while (x.index > i + k) {
                    maxHeap.poll();
                    if (!maxHeap.isEmpty()) {
                        x = maxHeap.peek();
                    }
                }
                dp[i] = nums[i] + x.value;
                maxHeap.offer(new IndexedValue(i, dp[i]));
            }

            return dp[0];
        }
    }

    // O(N) time | O(N) space
    // Resource: https://dev.to/seanpgallivan/solution-jump-game-vi-4a2
    class JumpGame6UsingDequeAsSlidingWindow implements JumpGame6 {

        @Override
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            // dp[i] denotes max score you can get when reaching index n - 1 from index i.
            // We're going to fill in dp[] iterating from right to left.
            int[] dp = new int[n];
            dp[n - 1] = nums[n - 1];

            // Sliding window of size <= k; stores indices.
            Deque<Integer> deq = new ArrayDeque<>();
            deq.offerLast(n - 1);

            for (int i = n - 2; i >= 0; i--) {
                if (deq.peekFirst() - i > k) {
                    deq.pollFirst();
                }
                dp[i] = nums[i] + dp[deq.peekFirst()];
                while (!deq.isEmpty() && dp[deq.peekLast()] <= dp[i]) {
                    deq.pollLast();
                }
                deq.offerLast(i);
            }
            return dp[0];
        }
    }
}
