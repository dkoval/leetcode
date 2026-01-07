package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
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
public interface MaximumProductOfSplittedBinaryTree {

    int MOD = 1000_000_007;

    int maxProduct(TreeNode root);

    // O(N) time | O(H) space, where
    // N is the total number of nodes in the binary tree,
    // H is the height of the tree
    class MaximumProductOfSplittedBinaryTreeRev1 implements MaximumProductOfSplittedBinaryTree {

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

        private static class TreeInfo {
            final long treeSum;
            long maxProduct = Long.MIN_VALUE;

            TreeInfo(long treeSum) {
                this.treeSum = treeSum;
            }
        }
    }

    class MaximumProductOfSplittedBinaryTreeRev2 implements MaximumProductOfSplittedBinaryTree {

        @Override
        public int maxProduct(TreeNode root) {
            final var sums = new HashMap<TreeNode, Long>();
            final var totalSum = sum(root, sums);

            final var best = traverse(root, totalSum, sums);
            return (int) (best % MOD);
        }

        private long sum(TreeNode node, Map<TreeNode, Long> sums) {
            if (node == null) {
                return 0L;
            }

            // already solved?
            if (sums.containsKey(node)) {
                return sums.get(node);
            }

            var sum = (long) node.val;
            sum += sum(node.left, sums);
            sum += sum(node.right, sums);

            // cache and return the result
            sums.put(node, sum);
            return sum;
        }

        private long traverse(TreeNode node, long totalSum, Map<TreeNode, Long> sums) {
            // pre-order traversal
            if (node == null) {
                return Long.MIN_VALUE;
            }

            var best = Long.MIN_VALUE;

            // option #1: remove left edge
            final var leftSum = sum(node.left, sums);
            best = Math.max(best, product(totalSum, leftSum));

            // option #2: remove right edgt
            final var rightSum = sum(node.right, sums);
            best = Math.max(best, product(totalSum, rightSum));

            best = Math.max(best, traverse(node.left, totalSum, sums));
            best = Math.max(best, traverse(node.right, totalSum, sums));
            return best;
        }

        private long product(long totalSum, long subtreeSum) {
            var product = subtreeSum;
            product *= (totalSum - subtreeSum);
            return product;
        }
    }
}
