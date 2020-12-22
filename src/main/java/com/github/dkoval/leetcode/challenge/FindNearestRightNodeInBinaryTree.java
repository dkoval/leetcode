package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3576/">Find Nearest Right Node in Binary Tree</a>
 * <p>
 * Given the root of a binary tree and a node u in the tree, return the nearest node on the same level
 * that is to the right of u, or return null if u is the rightmost node in its level.
 */
public class FindNearestRightNodeInBinaryTree {

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean found = false;
            while (size-- > 0) {
                TreeNode v = q.poll();
                if (found) {
                    return v;
                }
                if (u == v) {
                    found = true;
                }
                if (v.left != null) {
                    q.offer(v.left);
                }
                if (v.right != null) {
                    q.offer(v.right);
                }
            }
        }
        return null;
    }
}
