package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees/">Unique Binary Search Trees</a>
 * <p>
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 19
 */
public interface UniqueBinarySearchTrees {

    int numTrees(int n);

    // O(N^2) time | O(N) space
    class UniqueBinarySearchTreesDPTopDown implements UniqueBinarySearchTrees {

        public int numTrees(int n) {
            // memo[i] is the number of unique BSTs with i nodes
            Integer[] memo = new Integer[n + 1];
            return numTrees(n, memo);
        }

        // input x is in [0 : N - 1] range
        // each input takes O(N) time -> overall O(N^2) time | O(N) space to allocate memo[]
        private int numTrees(int x, Integer[] memo) {
            if (x < 1) {
                return 1;
            }

            if (memo[x] != null) {
                return memo[x];
            }

            // l - number of nodes in the left subtree
            // r - number of nodes in the right subtree
            int count = 0;
            for (int l = 0; l < x; l++) {
                int r = x - l - 1;
                count += numTrees(l, memo) * numTrees(r, memo);
            }

            memo[x] = count;
            return count;
        }
    }
}
