package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-original-array-of-prefix-xor/">Find The Original Array of Prefix Xor</a>
 * <p>
 * You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
 * <pre><code>
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * </code></pre>
 * Note that ^ denotes the bitwise-xor operation.
 * <p>
 * It can be proven that the answer is unique.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= pref.length <= 10^5</li>
 *  <li>0 <= pref[i] <= 10^6</li>
 * </ul>
 */
public interface FindOriginalArrayOfPrefixXor {

    int[] findArray(int[] pref);

    // O(N) time | O(1) extra space
    class FindOriginalArrayOfPrefixXorRev1 implements FindOriginalArrayOfPrefixXor {

        @Override
        public int[] findArray(int[] pref) {
            int n = pref.length;

            // properties of XOR
            // a ^ a = 0
            // a ^ 0 = a

            // pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]
            // <=>
            // pref[i] = pref[i - 1] ^ arr[i]
            // =>
            // arr[i] = pref[i - 1] ^ pref[i]
            int[] arr = new int[n];
            arr[0] = pref[0];
            for (int i = 1; i < n; i++) {
                arr[i] = pref[i - 1] ^ pref[i];
            }
            return arr;
        }
    }
}
