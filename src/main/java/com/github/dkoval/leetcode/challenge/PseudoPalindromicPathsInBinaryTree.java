package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/">Pseudo-Palindromic Paths in a Binary Tree</a>
 * <p>
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic
 * if at least one permutation of the node values in the path is a palindrome.
 * <p>
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^5]</li>
 *  <li>1 <= Node.val <= 9</li>
 * </ul>
 */
public interface PseudoPalindromicPathsInBinaryTree {

    int pseudoPalindromicPaths(TreeNode root);

    // O(N) time | O(H) space
    class PseudoPalindromicPathsInBinaryTreeRev1 implements PseudoPalindromicPathsInBinaryTree {

        @Override
        public int pseudoPalindromicPaths(TreeNode root) {
            return dfs(root, new int[10]);
        }

        private int dfs(TreeNode root, int[] counts) {
            if (root == null) {
                return 0;
            }

            counts[root.val]++;
            int ans = 0;

            if (root.left == null && root.right == null) {
                if (isPseudoPalindromic(counts)) {
                    ans++;
                }
            } else {
                ans += dfs(root.left, counts);
                ans += dfs(root.right, counts);
            }

            // backtrack
            counts[root.val]--;
            return ans;
        }

        private boolean isPseudoPalindromic(int[] counts) {
            // count digits having odd frequency
            int odds = 0;
            for (int i = 1; i <= 9; i++) {
                if (counts[i] % 2 != 0) {
                    odds++;
                    if (odds > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
