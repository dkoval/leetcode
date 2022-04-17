package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/increasing-order-search-tree/">Increasing Order Search Tree</a>
 * <p>
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now
 * the root of the tree, and every node has no left child and only one right child.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the given tree will be in the range [1, 100]</li>
 *  <li>0 <= Node.val <= 1000</li>
 * </ul>
 */
public abstract class IncreasingOrderSearchTree {

    public abstract TreeNode increasingBST(TreeNode root);

    // O(N) time | O(N) size
    public static class IncreasingOrderSearchTreeUsingInorderTraversal extends IncreasingOrderSearchTree {

        @Override
        public TreeNode increasingBST(TreeNode root) {
            // Idea: inorder traversal of a BST visits nodes in the increasing order of their values
            List<TreeNode> traversal = new ArrayList<>();
            inorder(root, traversal);

            TreeNode dummy = new TreeNode(42);
            TreeNode curr = dummy;
            for (TreeNode node : traversal) {
                curr.right = node;
                node.left = null;
                curr = curr.right;
            }
            return dummy.right;
        }

        private void inorder(TreeNode root, List<TreeNode> traversal) {
            if (root == null) {
                return;
            }

            // visit left subtree
            inorder(root.left, traversal);
            traversal.add(root);
            // visit right subtree
            inorder(root.right, traversal);
        }
    }

    // O(N) time | O(H) space, where H is the height of the given tree,
    // and the size of the implicit call stack in our in-order traversal.
    public static class IncreasingOrderSearchTreeUsingInorderTraversalWithRelinking extends IncreasingOrderSearchTree {

        @Override
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummyRoot = new TreeNode(42);
            inorder(root, new TreeNode[]{dummyRoot});
            return dummyRoot.right;
        }

        private void inorder(TreeNode root, TreeNode[] curr) {
            if (root == null) {
                return;
            }

            // visit left subtree
            inorder(root.left, curr);

            curr[0].right = root;
            root.left = null;
            curr[0] = curr[0].right;

            // visit right subtree
            inorder(root.right, curr);
        }
    }
}
