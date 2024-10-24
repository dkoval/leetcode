package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/flip-equivalent-binary-trees/">Flip Equivalent Binary Trees</a>
 * <p>
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
 * <p>
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
 * <p>
 * Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in each tree is in the range [0, 100].</li>
 *  <li>Each tree will have unique node values in the range [0, 99].</li>
 * </ul>
 */
public interface FlipEquivalentBinaryTrees {

    boolean flipEquiv(TreeNode root1, TreeNode root2);

    class FlipEquivalentBinaryTreesRev1 implements FlipEquivalentBinaryTrees {

        @Override
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2 == null;
            }

            if (root2 == null) {
                return false;
            }

            if (root1.val != root2.val) {
                return false;
            }

            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                    || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        }
    }

    class FlipEquivalentBinaryTreesRev2 implements FlipEquivalentBinaryTrees {

        @Override
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }

            if (root1 == null || root2 == null) {
                return false;
            }

            if (root1.val != root2.val) {
                return false;
            }

            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                    || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        }
    }
}
