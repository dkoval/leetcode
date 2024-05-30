package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/">Count Triplets That Can Form Two Arrays of Equal XOR</a>
 * <p>
 * Given an array of integers arr.
 * <p>
 * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
 * <p>
 * Let's define a and b as follows:
 * <ul>
 *  <li>a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]</li>
 *  <li>b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]</li>
 * </ul>
 * Note that ^ denotes the bitwise-xor operation.
 * <p>
 * Return the number of triplets (i, j and k) Where a == b.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 300</li>
 *  <li>1 <= arr[i] <= 10^8</li>
 * </ul>
 */
public interface CountTripletsThatCanFormTwoArraysOfEqualXOR {

    int countTriplets(int[] arr);

    // O(N^3) time | O(1) space
    class CountTripletsThatCanFormTwoArraysOfEqualXORRev1 implements CountTripletsThatCanFormTwoArraysOfEqualXOR {

        @Override
        public int countTriplets(int[] arr) {
            int n = arr.length;

            // We're looking for indices i < j <= k such that
            // xor(arr[i : j - 1]) = xor(arr[j : k])
            // <=>
            // xor(arr[i : j - 1]) ^ xor(arr[j : k]) = 0
            // <=>
            // xor(arr[i : k]) = 0
            // => there are (k - i) possibilities to put index j between i and k (i < j <= k)
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int k = i + 1; k < n; k++) {
                    if (xor(arr, i, k) == 0) {
                        count += k - i;
                    }
                }
            }
            return count;
        }

        private int xor(int[] arr, int left, int right) {
            int ans = 0;
            for (int i = left; i <= right; i++) {
                ans ^= arr[i];
            }
            return ans;
        }
    }
}
