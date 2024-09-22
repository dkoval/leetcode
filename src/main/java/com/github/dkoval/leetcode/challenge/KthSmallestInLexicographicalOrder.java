package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/">K-th Smallest in Lexicographical Order</a>
 * <p>
 * Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= n <= 10^9
 */
public interface KthSmallestInLexicographicalOrder {

    int findKthNumber(int n, int k);

    class KthSmallestInLexicographicalOrderTLE implements KthSmallestInLexicographicalOrder {

        @Override
        public int findKthNumber(int n, int k) {
            long x = 1;
            while (k > 1) {
                if (x * 10 <= n) {
                    x *= 10;
                } else {
                    while (x == n || x % 10 == 9) {
                        // remove last digit
                        x /= 10;
                    }
                    x++;
                }
                k--;
            }
            return (int) x;
        }
    }
}
