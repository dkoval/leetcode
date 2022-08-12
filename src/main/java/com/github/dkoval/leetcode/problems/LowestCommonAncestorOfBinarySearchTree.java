package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Lowest Common Ancestor of a Binary Search Tree</a>
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
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
public class LowestCommonAncestorOfBinarySearchTree {

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

        path.add(root);
        if (root.val == target.val) {
            return true;
        }

        // leverage BST property
        boolean found = (root.val > target.val)
                ? dfs(root.left, target, path)   // search in the left subtree
                : dfs(root.right, target, path); // search in the right subtree

        if (!found) {
            path.remove(path.size() - 1); // backtrack
        }
        return found;
    }
}
