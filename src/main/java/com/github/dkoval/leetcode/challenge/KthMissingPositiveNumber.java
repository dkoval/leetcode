package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/kth-missing-positive-number/">Kth Missing Positive Number</a>
 * <p>
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * <p>
 * Return the kth positive integer that is missing from this array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 1000</li>
 *  <li>1 <= arr[i] <= 1000</li>
 *  <li>1 <= k <= 1000</li>
 *  <li>arr[i] < arr[j] for 1 <= i < j <= arr.length</li>
 * </ul>
 */
public class KthMissingPositiveNumber {

    // O(N) time | O(1) space
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        // numbers missing from the left
        if (arr[0] > 1) {
            int missing = arr[0] - 1;
            if (missing >= k) {
                return k;
            }
            k -= missing;
        }

        // numbers missing in the middle
        for (int i = 1; i < n; i++) {
            int missing = arr[i] - arr[i - 1] - 1;
            if (missing >= k) {
                return arr[i - 1] + k;
            }
            k -= missing;
        }

        // numbers missing from the right
        return arr[n - 1] + k;
    }
}
