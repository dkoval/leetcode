package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/merge-two-binary-trees/">Merge Two Binary Trees</a>
 * <p>
 * You are given two binary trees root1 and root2.
 * <p>
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * <p>
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in both trees is in the range [0, 2000]</li>
 *  <li>-10^4 <= Node.val <= 10^4</li>
 * </ul>
 */
public interface MergeTwoBinaryTrees {

    TreeNode mergeTrees(TreeNode root1, TreeNode root2);

    class MergeTwoBinaryTreesRecursive implements MergeTwoBinaryTrees {

        @Override
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }

            if (root2 == null) {
                return root1;
            }

            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
