package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3772/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // Resource: https://www.youtube.com/watch?v=PoBGyrIWisE
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(inorder, 0, inorder.length - 1, preorder, buildIndex(preorder), buildIndex(inorder));
    }

    private Map<Integer, Integer> buildIndex(int[] elements) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            index.put(elements[i], i);
        }
        return index;
    }

    private TreeNode buildTree(int[] inorder, int start, int end,
                               int[] preorder,
                               Map<Integer, Integer> preorderIndex,
                               Map<Integer, Integer> inorderIndex) {
        if (end < start) {
            return null;
        }

        // the root's value is a value from inorder[start:end] that appears first in preorder[]
        int rootVal = findRoot(inorder, start, end, preorder, preorderIndex);
        // now, get the root's value index in inorder[]
        int inorderRootIdx = inorderIndex.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, start, inorderRootIdx - 1, preorder, preorderIndex, inorderIndex);
        root.right = buildTree(inorder, inorderRootIdx + 1, end, preorder, preorderIndex, inorderIndex);
        return root;
    }

    private int findRoot(int[] inorder, int start, int end,
                         int[] preorder,
                         Map<Integer, Integer> preorderIndex) {
        if (end - start + 1 == inorder.length) {
            return preorder[0];
        }

        int preorderMinIdx = inorder.length;
        for (int i = start; i <= end; i++) {
            int preorderCurrIdx = preorderIndex.get(inorder[i]);
            preorderMinIdx = Math.min(preorderMinIdx, preorderCurrIdx);
        }
        return preorder[preorderMinIdx];
    }
}
