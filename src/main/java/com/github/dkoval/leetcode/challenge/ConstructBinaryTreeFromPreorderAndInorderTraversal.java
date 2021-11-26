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
        // inorder.length == preorder.length
        int n = preorder.length;
        return doBuildTree(preorder, 0, n - 1, inorder, 0, n - 1, indices(inorder));
    }

    private Map<Integer, Integer> indices(int[] nums) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        return index;
    }

    private TreeNode doBuildTree(int[] preorder, int preorderStart, int preorderEnd,
                                 int[] inorder, int inorderStart, int inorderEnd,
                                 Map<Integer, Integer> inorderIndices) {

        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);

        // Now, get the root's value index in inorder[].
        // Values from inorder[inorderStart : inorderRootIdx - 1] and inorder[inorderRootIdx + 1 : inorderEnd] subarrays
        // form left and right subtrees respectively.
        int inorderRootIdx = inorderIndices.get(preorder[preorderStart]);
        int numNodesLeft = inorderRootIdx - inorderStart;

        root.left = doBuildTree(
                preorder, preorderStart + 1, preorderStart + numNodesLeft,
                inorder, inorderStart, inorderRootIdx - 1, inorderIndices);

        root.right = doBuildTree(
                preorder, preorderStart + numNodesLeft + 1, preorderEnd,
                inorder, inorderRootIdx + 1, inorderEnd, inorderIndices);

        return root;
    }
}
