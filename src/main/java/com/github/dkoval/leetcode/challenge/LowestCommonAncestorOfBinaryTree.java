package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest Common Ancestor of a Binary Tree</a>
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q
 * as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [2, 10^5]</li>
 *  <li>-10^9 <= Node.val <= 10^9</li>
 *  <li>All Node.val are unique</li>
 *  <li>p != q</li>
 *  <li>p and q will exist in the BST</li>
 * </ul>
 */
public interface LowestCommonAncestorOfBinaryTree {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);

    class LowestCommonAncestorOfBinaryTreeUsingListToStorePathRev1 implements LowestCommonAncestorOfBinaryTree {

        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> pPath = find(root, p);
            List<TreeNode> qPath = find(root, q);

            TreeNode lca = root;
            int i = 0;
            while (i < pPath.size() && i < qPath.size()) {
                TreeNode pNode = pPath.get(i);
                TreeNode qNode = qPath.get(i);
                if (pNode.val != qNode.val) {
                    break;
                }
                lca = pNode;
                i++;
            }
            return lca;
        }

        private List<TreeNode> find(TreeNode root, TreeNode target) {
            List<TreeNode> path = new ArrayList<>();
            dfs(root, target, path);
            return path;
        }

        private boolean dfs(TreeNode root, TreeNode target, List<TreeNode> path) {
            if (root == null) {
                return false;
            }

            boolean found;
            path.add(root);

            if (root.val == target.val) {
                return true;
            }

            found = dfs(root.left, target, path) || dfs(root.right, target, path);

            // backtrack
            if (!found) {
                path.remove(path.size() - 1);
            }

            return found;
        }
    }

    class LowestCommonAncestorOfBinaryTreeUsingListToStorePathRev2 implements LowestCommonAncestorOfBinaryTree {

        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> pPath = find(root, p);
            List<TreeNode> qPath = find(root, q);

            int len = Math.min(pPath.size(), qPath.size());
            for (int i = 1; i < len; i++) {
                if (pPath.get(i) != qPath.get(i)) {
                    return pPath.get(i - 1);
                }
            }
            return pPath.get(len - 1);
        }

        private List<TreeNode> find(TreeNode root, TreeNode target) {
            List<TreeNode> path = new ArrayList<>();
            dfs(root, target, path);
            return path;
        }

        private boolean dfs(TreeNode root, TreeNode target, List<TreeNode> path) {
            if (root == null) {
                return false;
            }

            boolean found;
            path.add(root);

            if (root == target) {
                return true;
            }

            found = dfs(root.left, target, path) || dfs(root.right, target, path);

            // backtrack
            if (!found) {
                path.remove(path.size() - 1);
            }

            return found;
        }
    }

    class LowestCommonAncestorOfBinaryTreeUsingDequeToStorePath implements LowestCommonAncestorOfBinaryTree {

        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Deque<TreeNode> pPath = path(root, p);
            Deque<TreeNode> qPath = path(root, q);

            // While traversing p- and q- paths, find the first p != q pair.
            // If found, LCA is the previous node in the path, otherwise - the root node.
            TreeNode lca = root;
            while (!pPath.isEmpty() && !qPath.isEmpty()) {
                TreeNode pNode = pPath.pollFirst();
                TreeNode qNode = qPath.pollFirst();
                if (pNode.val != qNode.val) {
                    return lca;
                }
                lca = pNode;
            }
            return lca;
        }

        private Deque<TreeNode> path(TreeNode root, TreeNode target) {
            if (root == null) {
                return new LinkedList<>();
            }

            if (root.val == target.val) {
                Deque<TreeNode> path = new LinkedList<>();
                path.addFirst(root);
                return path;
            }

            Deque<TreeNode> left = path(root.left, target);
            if (!left.isEmpty()) {
                left.addFirst(root);
                return left;
            }

            Deque<TreeNode> right = path(root.right, target);
            if (!right.isEmpty()) {
                right.addFirst(root);
                return right;
            }

            return new LinkedList<>();
        }
    }
}
