package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/">Find Mode in Binary Search Tree</a>
 * <p>
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 * <p>
 * If the tree has more than one mode, return them in any order.
 * <p>
 * Assume a BST is defined as follows:
 * <ul>
 *  <li>The left subtree of a node contains only nodes with keys less than or equal to the node's key.</li>
 *  <li>The right subtree of a node contains only nodes with keys greater than or equal to the node's key.</li>
 *  <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 */
public interface FindModeInBinarySearchTree {

    int[] findMode(TreeNode root);

    class FindModeInBinarySearchTreeRev1 implements FindModeInBinarySearchTree {

        @Override
        public int[] findMode(TreeNode root) {
            // in-order traversal of a BST visits its nodes in increasing order of their values, therefore
            // in-order traversal of a BST ensures that duplicate node values appear next to each other
            // in the traversal's output
            TraversalContext context = new TraversalContext();
            inorder(root, context);

            int i = 0;
            int[] ans = new int[context.modes.size()];
            for (int x : context.modes) {
                ans[i++] = x;
            }
            return ans;
        }

        private void inorder(TreeNode root, TraversalContext context) {
            if (root == null) {
                return;
            }

            inorder(root.left, context);
            process(root, context);
            inorder(root.right, context);
        }

        private void process(TreeNode root, TraversalContext context) {
            // update the current node
            if (context.curr != null && context.curr == root.val) {
                context.currCount++;
            } else {
                context.curr = root.val;
                context.currCount = 1;
            }

            // update the most frequent node(s)
            if (context.currCount > context.modesCount) {
                context.modes = new ArrayList<>(List.of(context.curr));
                context.modesCount = context.currCount;
            } else if (context.currCount == context.modesCount) {
                context.modes.add(context.curr);
            }
        }

        private static class TraversalContext {
            List<Integer> modes = new ArrayList<>();
            int modesCount = 0;
            Integer curr = null;
            int currCount = 0;
        }
    }
}
