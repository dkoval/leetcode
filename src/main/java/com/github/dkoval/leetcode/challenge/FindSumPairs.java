package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/finding-pairs-with-a-certain-sum/">Finding Pairs With a Certain Sum</a>
 * <p>
 * Implement the FindSumPairs class:
 * <ul>
 *  <li>FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.</li>
 *  <li>void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.</li>
 *  <li>int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.</li>
 * </ul>
 */
public abstract class FindSumPairs {

    public FindSumPairs(int[] nums1, int[] nums2) {
        // Initialize the FindSumPairs object with two integer arrays nums1 and nums2
    }

    public abstract void add(int index, int val);

    public abstract int count(int tot);

    static class FindSumPairsRev1 extends FindSumPairs {
        private final int[] nums1;
        private final int[] nums2;
        private final Map<Integer, Integer> freqs2;

        public FindSumPairsRev1(int[] nums1, int[] nums2) {
            super(nums1, nums2);
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.freqs2 = frequencies(nums2);
        }

        private static Map<Integer, Integer> frequencies(int[] nums) {
            final var freqs = new HashMap<Integer, Integer>();
            for (var x : nums) {
                freqs.put(x, freqs.getOrDefault(x, 0) + 1);
            }
            return freqs;
        }

        public void add(int index, int val) {
            freqs2.put(nums2[index], freqs2.get(nums2[index]) - 1);
            nums2[index] += val;
            freqs2.put(nums2[index], freqs2.getOrDefault(nums2[index], 0) + 1);
        }

        public int count(int tot) {
            // 1 <= nums1.length <= 1000
            var count = 0;
            for (var x : nums1) {
                final var complement = tot - x;
                if (freqs2.containsKey(complement)) {
                    count += freqs2.get(complement);
                }
            }
            return count;
        }
    }
}
