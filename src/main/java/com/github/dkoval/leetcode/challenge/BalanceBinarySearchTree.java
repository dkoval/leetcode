package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/balance-a-binary-search-tree/">Balance a Binary Search Tree</a>
 * <p>
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
 * If there is more than one answer, return any of them.
 * <p>
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^4]</li>
 *  <li>1 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface BalanceBinarySearchTree {

    TreeNode balanceBST(TreeNode root);

    // O(N) time | O(N) space
    class BalanceBinarySearchTreeRev1 implements BalanceBinarySearchTree {

        @Override
        public TreeNode balanceBST(TreeNode root) {
            List<TreeNode> inorder = traverse(root, new ArrayList<>());
            return createBalancedBST(inorder, 0, inorder.size() - 1);
        }

        private List<TreeNode> traverse(TreeNode node, List<TreeNode> nodes) {
            if (node != null) {
                // inorder traversal
                traverse(node.left, nodes);
                nodes.add(node);
                traverse(node.right, nodes);
            }
            return nodes;
        }

        private TreeNode createBalancedBST(List<TreeNode> nodes, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = left + (right - left) / 2;
            TreeNode root = nodes.get(mid);
            root.left = createBalancedBST(nodes, left, mid - 1);
            root.right = createBalancedBST(nodes, mid + 1, right);
            return root;
        }
    }
}
