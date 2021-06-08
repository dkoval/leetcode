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

    private static class MutableInt {
        int val;

        MutableInt(int val) {
            this.val = val;
        }
    }

    // Resource: https://www.youtube.com/watch?v=PoBGyrIWisE
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(inorder, 0, inorder.length - 1, buildIndex(inorder), preorder, new MutableInt(0));
    }

    private Map<Integer, Integer> buildIndex(int[] elements) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            index.put(elements[i], i);
        }
        return index;
    }

    private TreeNode buildTree(int[] inorder,
                               int inorderStartIdx,
                               int inorderEndIdx,
                               Map<Integer, Integer> inorderIndex,
                               int[] preorder,
                               MutableInt preorderIdx) {

        if (inorderEndIdx < inorderStartIdx) {
            return null;
        }

        int rootVal = preorder[preorderIdx.val++];
        TreeNode root = new TreeNode(rootVal);

        // Now, get the root's value index in inorder[].
        // Values from inorder[inorderStartIdx:inorderRootIdx - 1] and inorder[inorderRootIdx + 1:inorderEndIdx] subarrays
        // form left and right subtrees respectively.
        int inorderRootIdx = inorderIndex.get(rootVal);

        root.left = buildTree(inorder, inorderStartIdx, inorderRootIdx - 1, inorderIndex, preorder, preorderIdx);
        root.right = buildTree(inorder, inorderRootIdx + 1, inorderEndIdx, inorderIndex, preorder, preorderIdx);
        return root;
    }
}
