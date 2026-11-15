package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/">Number of Sub-arrays With Odd Sum</a>
 * <p>
 * Given an array of integers arr, return the number of subarrays with an odd sum.
 * <p>
 * Since the answer can be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 10^5</li>
 *  <li>1 <= arr[i] <= 100</li>
 * </ul>
 */
public interface NumberOfSubarraysWithOddSum {

    int MOD = 1_000_000_007;

    int numOfSubarrays(int[] arr);

    class NumberOfSubarraysWithOddSumRev1 implements NumberOfSubarraysWithOddSum {

        @Override
        public int numOfSubarrays(int[] arr) {
            // Idea: consider contribution of each arr[i] to the result

            // prefix sum
            // | --- | --- | ... | ... |
            // 0     ^     ^     i     n - 1
            // <-----> (even)
            // <-----------> (even)
            // <-----------------> (odd)

            var count = 0;
            var sum = 0;

            // at any given index i:
            // prev[0] - the number of subarrays with even prefix sum
            // prev[1] - the number of subarrays with odd prefix sum
            final var prev = new int[]{0, 0};
            prev[0] = 1; // since the initial sum (0) is even

            for (var x : arr) {
                sum += x;
                // case 1: if current sum is even, append nums[i] to subarrays with odd sum
                // case 2: if current sum is odd, append nums[i] to subarrays with even sum
                count += prev[1 - (sum % 2)];
                count %= MOD;
                prev[sum % 2]++;
            }
            return count;
        }
    }
}
