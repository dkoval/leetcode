package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= preorder.length <= 3000</li>
 *  <li>inorder.length == preorder.length</li>
 *  <li>-3000 <= preorder[i], inorder[i] <= 3000</li>
 *  <li>preorder and inorder consist of unique values</li>
 *  <li>Each value of inorder also appears in preorder</li>
 *  <li>preorder is guaranteed to be the preorder traversal of the tree</li>
 *  <li>inorder is guaranteed to be the inorder traversal of the tree</li>
 * </ul>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // Resource: https://www.youtube.com/watch?v=PoBGyrIWisE
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder: ROOT, LEFT, RIGHT
        // inorder: LEFT, ROOT, RIGHT
        int n = preorder.length;
        return doBuildTree(preorder, 0, n - 1, indices(inorder), 0, n - 1);
    }

    private Map<Integer, Integer> indices(int[] nums) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        return index;
    }

    private TreeNode doBuildTree(int[] preorder, int preorderStart, int preorderEnd,
                                 Map<Integer, Integer> inorder, int inorderStart, int inorderEnd) {

        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);

        // Now, get the root's value index in inorder[].
        // Values from inorder[inorderStart : inorderRootIdx - 1] and inorder[inorderRootIdx + 1 : inorderEnd] subarrays
        // form left and right subtrees respectively.
        int inorderRootIdx = inorder.get(preorder[preorderStart]);
        int numNodesLeft = inorderRootIdx - inorderStart;

        root.left = doBuildTree(
                preorder, preorderStart + 1, preorderStart + numNodesLeft,
                inorder, inorderStart, inorderRootIdx - 1);

        root.right = doBuildTree(
                preorder, preorderStart + numNodesLeft + 1, preorderEnd,
                inorder, inorderRootIdx + 1, inorderEnd);

        return root;
    }
}
