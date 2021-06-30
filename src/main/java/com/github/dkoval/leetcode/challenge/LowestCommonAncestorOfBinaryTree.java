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

    private static class Path {

        static final Path NOT_FOUND = new Path(false, new LinkedList<>());

        final boolean found;
        final Deque<TreeNode> seq;

        Path(boolean found, Deque<TreeNode> seq) {
            this.found = found;
            this.seq = seq;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Path pPath = find(root, p);
        Path qPath = find(root, q);

        TreeNode lca = root;
        while (!pPath.seq.isEmpty() && !qPath.seq.isEmpty()) {
            TreeNode pNode = pPath.seq.pollFirst();
            TreeNode qNode = qPath.seq.pollFirst();
            if (pNode.val != qNode.val) {
                return lca;
            }
            lca = pNode;
        }
        return lca;
    }

    private Path find(TreeNode curr, TreeNode target) {
        if (curr == null) {
            return Path.NOT_FOUND;
        }

        if (curr.val == target.val) {
            Deque<TreeNode> path = new LinkedList<>();
            path.offer(curr);
            return new Path(true, path);
        }

        Path left = find(curr.left, target);
        if (left.found) {
            Deque<TreeNode> path = left.seq;
            path.offerFirst(curr);
            return new Path(true, path);
        }

        Path right = find(curr.right, target);
        if (right.found) {
            Deque<TreeNode> path = right.seq;
            path.offerFirst(curr);
            return new Path(true, path);
        }

        return Path.NOT_FOUND;
    }
}
