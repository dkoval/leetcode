package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">K-th Symbol in Grammar</a>
 * <p>
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row,
 * we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
 * <p>
 * Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 30</li>
 *  <li>1 <= k <= 2^(n - 1)</li>
 * </ul>
 */
public interface KthSymbolInGrammar {

    int kthGrammar(int n, int k);

    class KthSymbolInGrammarRev1 implements KthSymbolInGrammar {

        @Override
        public int kthGrammar(int n, int k) {
            // 0 -> 01
            // 1 -> 10
            // Represent like binary tree
            //  0      1
            // / \ or / \
            // 0  1   1  0
            return calc(n - 1, k - 1);
        }

        private int calc(int row, int col) {
            // base cases
            if (row == 0) {
                return 0;
            }

            // in a complete binary tree, the column of the parent node = col / 2
            int x = calc(row - 1, col / 2);
            // determine if the current node is either the left or the right child of its parent
            boolean left = (col % 2) == 0;
            if (x == 0) {
                return left ? 0 : 1;
            }
            return left ? 1 : 0;
        }
    }
}
