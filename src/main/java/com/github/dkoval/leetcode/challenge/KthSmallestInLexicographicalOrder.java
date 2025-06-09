package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/">K-th Smallest in Lexicographical Order (Hard)</a>
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

    class KthSmallestInLexicographicalOrderRev2 implements KthSmallestInLexicographicalOrder {

        @Override
        public int findKthNumber(int n, int k) {
            var x = 1L;
            while (k > 1) {
                final var count = countNodesInSubtree(x, n);
                if (count < k) {
                    // not enough nodes in a subtree rooting at x, move to the right subtree (that is, move to the next number)
                    x++;
                    k -= count;
                } else {
                    // move 1 level down
                    x *= 10;
                    k--;
                }
            }
            return (int) x;
        }

        private int countNodesInSubtree(long curr, int n) {
            var next = curr + 1;
            var count = 0;
            while (curr <= n) {
                count += Math.min(next, n + 1) - curr;
                // move curr and next pointers 1 level down
                curr *= 10;
                next *= 10;
            }
            return count;
        }
    }
}
