package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/607/week-5-june-29th-june-30th/3797/">Lowest Common Ancestor of a Binary Tree</a>
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q
 * as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pPath = find(root, p);
        Deque<TreeNode> qPath = find(root, q);

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

    private Deque<TreeNode> find(TreeNode root, TreeNode target) {
        if (root == null) {
            return new LinkedList<>();
        }

        if (root.val == target.val) {
            Deque<TreeNode> path = new LinkedList<>();
            path.addFirst(root);
            return path;
        }

        Deque<TreeNode> left = find(root.left, target);
        if (!left.isEmpty()) {
            left.addFirst(root);
            return left;
        }

        Deque<TreeNode> right = find(root.right, target);
        if (!right.isEmpty()) {
            right.addFirst(root);
            return right;
        }

        return new LinkedList<>();
    }
}
