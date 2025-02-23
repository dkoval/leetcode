package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/">Construct Binary Tree from Preorder and Postorder Traversal</a>
 * <p>
 * Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
 * <p>
 * If there exist multiple answers, you can return any of them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= preorder.length <= 30</li>
 *  <li>1 <= preorder[i] <= preorder.length</li>
 *  <li>All the values of preorder are unique.</li>
 *  <li>postorder.length == preorder.length</li>
 *  <li>1 <= postorder[i] <= postorder.length</li>
 *  <li>All the values of postorder are unique.</li>
 *  <li>It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.</li>
 * </ul>
 */
public interface ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    TreeNode constructFromPrePost(int[] preorder, int[] postorder);

    class ConstructBinaryTreeFromPreorderAndPostorderTraversalRev1 implements ConstructBinaryTreeFromPreorderAndPostorderTraversal {

        @Override
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            final var n = postorder.length;

            // values are 1 .. n
            final var postValueToIndex = new int[n + 1];
            for (int i = 0; i < n; i++) {
                postValueToIndex[postorder[i]] = i;
            }

            return construct(preorder, 0, n - 1, postorder, 0, n - 1, postValueToIndex);
        }

        private TreeNode construct(
                int[] preorder,
                int preStart,
                int preEnd,
                int[] postorder,
                int postStart,
                int postEnd,
                int[] postValueToIndex
        ) {
            if (preStart > preEnd || postStart > postEnd) {
                return null;
            }

            // NB. postorder[postEnd] is also valid ROOT value
            final var root = new TreeNode(preorder[preStart]);

            if (preStart != preEnd) {
                final var leftValue = preorder[preStart + 1];
                final var leftPostIndex = postValueToIndex[leftValue];
                final var leftTreeSize = leftPostIndex - postStart + 1;

                root.left = construct(preorder, preStart + 1, preStart + leftTreeSize, postorder, postStart, leftPostIndex, postValueToIndex);
                root.right = construct(preorder, preStart + leftTreeSize + 1, preEnd, postorder, leftPostIndex + 1, postEnd - 1, postValueToIndex);
            }
            return root;
        }
    }

    class ConstructBinaryTreeFromPreorderAndPostorderTraversalRev2 implements ConstructBinaryTreeFromPreorderAndPostorderTraversal {

        private int preIdx = 0;
        private int postIdx = 0;

        @Override
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            TreeNode root = new TreeNode(preorder[preIdx++]);
            if (root.val != postorder[postIdx]) {
                root.left = constructFromPrePost(preorder, postorder);
            }
            if (root.val != postorder[postIdx]) {
                root.right = constructFromPrePost(preorder, postorder);
            }
            postIdx++;
            return root;
        }
    }
}
