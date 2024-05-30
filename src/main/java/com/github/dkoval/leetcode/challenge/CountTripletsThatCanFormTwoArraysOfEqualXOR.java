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

    // O(N^2) time | O(N) space
    class CountTripletsThatCanFormTwoArraysOfEqualXORRev2 implements CountTripletsThatCanFormTwoArraysOfEqualXOR {

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

            // prefix[i] = xor(arr[0 : i])
            // xor(arr[i : j]) = xor(arr[0 : j]) ^ xor(arr[0 : i - 1]) = prefix[j] ^ prefix[i - 1]
            int[] prefix = new int[n];
            prefix[0] = arr[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] ^ arr[i];
            }

            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int k = i + 1; k < n; k++) {
                    if (xor(prefix, i, k) == 0) {
                        count += k - i;
                    }
                }
            }
            return count;
        }

        private int xor(int[] prefix, int i, int j) {
            // x ^ 0 = x
            return prefix[j] ^ (i > 0 ? prefix[i - 1] : 0);
        }
    }
}
