package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/bitwise-xor-of-all-pairings/">Bitwise XOR of All Pairings</a>
 * <p>
 * You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array,
 * nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1
 * is paired with every integer in nums2 exactly once).
 * <p>
 * Return the bitwise XOR of all integers in nums3.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 10^5</li>
 *  <li>0 <= nums1[i], nums2[j] <= 10^9</li>
 * </ul>
 */
public interface BitwiseXOROfAllPairings {

    int xorAllNums(int[] nums1, int[] nums2);

    // O(N1 + N2) time | O(1) space
    class BitwiseXOROfAllPairingsRev1 implements BitwiseXOROfAllPairings {

        @Override
        public int xorAllNums(int[] nums1, int[] nums2) {
            // Example:
            // nums1 = [2,1,3]
            // nums2 = [10,2,5,0]
            //
            // All possible pairs:
            // (2, 10), (2, 2), (2, 5), (2, 0)
            // (1, 10), (1, 2), (1, 5), (1, 0)
            // (3, 10), (3, 2), (3, 5), (3, 0)

            final var n1 = nums1.length;
            final var n2 = nums2.length;

            // Properties of XOR:
            // x ^ x = 0
            // x ^ 0 = x
            var ans = 0;
            if (n1 % 2 != 0) {
                ans ^= xor(nums2);
            }

            if (n2 % 2 != 0) {
                ans ^= xor(nums1);
            }

            return ans;
        }

        private int xor(int[] xs) {
            var ans = 0;
            for (var x : xs) {
                ans ^= x;
            }
            return ans;
        }
    }
}
