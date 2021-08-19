package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.function.Consumer;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3903/">Maximum Product of Splitted Binary Tree</a>
 * <p>
 * Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
 * <p>
 * Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
 * <p>
 * Note that you need to maximize the answer before taking the mod and not after taking it.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [2, 5 * 10^4]</li>
 *  <li>1 <= Node.val <= 10^4</li>
 * </ul>
 */
public class MaximumProductOfSplittedBinaryTree {

    private static final int MOD = 1000_000_007;

    private static class TreeInfo {
        final long treeSum;
        long maxProduct = Long.MIN_VALUE;

        TreeInfo(long treeSum) {
            this.treeSum = treeSum;
        }
    }

    // O(N) time | O(H) space, where N is the total number of nodes in the binary tree, H is the height of the tree
    public int maxProduct(TreeNode root) {
        // 1st pass computes the sum of the entire tree
        long treeSum = sum(root, (subtreeSum) -> { /* nothing to do */ });
        TreeInfo info = new TreeInfo(treeSum);

        // 2nd pass computes the maximum product of the sums of the two subtrees
        sum(root, (subtreeSum) -> info.maxProduct = Math.max(info.maxProduct, subtreeSum * (info.treeSum - subtreeSum)));

        return (int) (info.maxProduct % MOD);
    }

    private long sum(TreeNode node, Consumer<Long> doWithSubtreeSum) {
        if (node == null) {
            return 0;
        }

        long subtreeSum = node.val + sum(node.left, doWithSubtreeSum) + sum(node.right, doWithSubtreeSum);
        doWithSubtreeSum.accept(subtreeSum);
        return subtreeSum;
    }
}
