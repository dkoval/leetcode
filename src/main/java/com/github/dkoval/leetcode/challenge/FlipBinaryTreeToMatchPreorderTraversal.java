package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3689/">Flip Binary Tree To Match Preorder Traversal</a>
 * <p>
 * You are given the root of a binary tree with n nodes, where each node is uniquely assigned a value from 1 to n.
 * You are also given a sequence of n values voyage, which is the desired pre-order traversal of the binary tree.
 * <p>
 * Flip the smallest number of nodes so that the pre-order traversal of the tree matches voyage.
 * <p>
 * Return a list of the values of all flipped nodes. You may return the answer in any order.
 * If it is impossible to flip the nodes in the tree to make the pre-order traversal match voyage, return the list [-1]
 */
public class FlipBinaryTreeToMatchPreorderTraversal {
    private int idx = 0;

    // O(N) time | O(N) space
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result = new ArrayList<>();
        boolean possible = preorder(root, voyage, result);
        return possible ? result : Collections.singletonList(-1);
    }

    private boolean preorder(TreeNode root, int[] voyage, List<Integer> result) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[idx++]) {
            return false;
        }
        if (root.left != null && root.left.val != voyage[idx]) {
            result.add(root.val);
            // reverse traversal: explore right child, then left
            return preorder(root.right, voyage, result)
                    && preorder(root.left, voyage, result);
        } else {
            // regular traversal: explore left child, then right
            return preorder(root.left, voyage, result)
                    && preorder(root.right, voyage, result);
        }
    }
}
