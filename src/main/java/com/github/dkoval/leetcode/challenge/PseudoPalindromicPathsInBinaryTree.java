package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3585/">Pseudo-Palindromic Paths in a Binary Tree</a>
 */
public class PseudoPalindromicPathsInBinaryTree {
    private final int[] digits = new int[10];
    private int count = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return count;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        digits[root.val]++;
        if (root.left == null && root.right == null && isPalindrome()) {
            count++;
        } else {
            dfs(root.left);
            dfs(root.right);
        }
        digits[root.val]--;
    }

    private boolean isPalindrome() {
        int numOddFrequencies = 0;
        for (int i = 1; i <= 9; i++) {
            if (digits[i] % 2 != 0) {
                numOddFrequencies++;
            }
        }
        return numOddFrequencies <= 1;
    }
}
