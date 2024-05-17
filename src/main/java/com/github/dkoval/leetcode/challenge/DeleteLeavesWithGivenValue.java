package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/delete-leaves-with-a-given-value/">Delete Leaves With a Given Value</a>
 * <p>
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 * <p>
 * Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target,
 * it should also be deleted (you need to continue doing that until you cannot).
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 3000]</li>
 *  <li>1 <= Node.val, target <= 1000</li>
 * </ul>
 */
public interface DeleteLeavesWithGivenValue {

    TreeNode removeLeafNodes(TreeNode root, int target);

    class DeleteLeavesWithGivenValueRev1 implements DeleteLeavesWithGivenValue {

        @Override
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            // base case
            if (root == null) {
                return null;
            }

            // post-order traversal
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);

            if (root.left == null && root.right == null && root.val == target) {
                return null;
            }
            return root;
        }
    }
}
