package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3634/">Convert BST to Greater Tree</a>
 * <p>
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <ul>
 *  <li>The left subtree of a node contains only nodes with keys less than the node's key.</li>
 *  <li>The right subtree of a node contains only nodes with keys greater than the node's key.</li>
 *  <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 */
public interface ConvertBSTToGreaterTree {

    TreeNode convertBST(TreeNode root);

    // O(N) time | O(H) space, where H - height of a BST
    class ConvertBSTToGreaterTreeWithRecursiveReverseInorderTraversal implements ConvertBSTToGreaterTree {

        private static class TreeInfo {
            int sum;

            TreeInfo(int sum) {
                this.sum = sum;
            }
        }

        @Override
        public TreeNode convertBST(TreeNode root) {
            return doConvertBST(root, new TreeInfo(0));
        }

        private TreeNode doConvertBST(TreeNode root, TreeInfo info) {
            if (root == null) {
                return null;
            }

            // reversed inorder traversal
            doConvertBST(root.right, info);
            info.sum += root.val;
            root.val = info.sum;
            doConvertBST(root.left, info);
            return root;
        }
    }

    // O(N) time | O(H) space, where H - height of a BST
    class ConvertBSTToGreaterTreeWithStackForReverseInorderTraversal implements ConvertBSTToGreaterTree {

        @Override
        public TreeNode convertBST(TreeNode root) {
            int sum = 0;
            TreeNode curr = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.right;
                }
                curr = stack.pop();
                sum += curr.val;
                curr.val = sum;
                curr = curr.left;
            }
            return root;
        }
    }

    // O(N) time | O(1) space
    // Resource: https://leetcode.com/problems/convert-bst-to-greater-tree/solution/
    class ConvertBSTToGreaterTreeWithReverseMorrisInorderTraversal implements ConvertBSTToGreaterTree {

        @Override
        public TreeNode convertBST(TreeNode root) {
            int sum = 0;
            TreeNode node = root;
            while (node != null) {
                if (node.right == null) {
                    // If there is no right subtree continue traversing left.
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                } else {
                    // If there is a right subtree, then there is at least one node that
                    // has a greater value than the current one, therefore, traverse that subtree first.
                    TreeNode successor = successor(node);
                    if (successor.left == null) {
                        // If the successor's left subtree is null, then we have never been here before.
                        // We temporarily link successor's left pointer to the current node and use this information
                        // to escape the subtree later on.
                        successor.left = node;
                        node = node.right;
                    } else {
                        // If there is a left subtree, it is a link that we created on a previous pass,
                        // so we should unlink it and visit this node.
                        successor.left = null;
                        sum += node.val;
                        node.val = sum;
                        node = node.left;
                    }
                }
            }
            return root;
        }

        private TreeNode successor(TreeNode node) {
            TreeNode successor = node.right;
            while (successor.left != null && successor.left != node) {
                successor = successor.left;
            }
            return successor;
        }
    }
}
