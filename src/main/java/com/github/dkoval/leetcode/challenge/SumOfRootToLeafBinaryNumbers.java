package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/">Sum of Root To Leaf Binary Numbers</a>
 * <p>
 * You are given the root of a binary tree where each node has a value 0 or 1.
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 * <p>
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bits integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 1000].</li>
 *  <li>Node.val is 0 or 1.</li>
 * </ul>
 */
public interface SumOfRootToLeafBinaryNumbers {

    int sumRootToLeaf(TreeNode root);

    class SumOfRootToLeafBinaryNumbersRev2 implements SumOfRootToLeafBinaryNumbers {

        @Override
        public int sumRootToLeaf(TreeNode root) {
            return traverse(root, 0);
        }

        private int traverse(TreeNode node, int x) {
            if (node == null) {
                return 0;
            }

            x *= 2;
            x += node.val;

            if (node.left == null && node.right == null) {
                return x;
            }

            return traverse(node.left, x) + traverse(node.right, x);
        }
    }
}
