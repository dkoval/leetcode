package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary Tree (Hard)</a>
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 104]</li>
 *  <li>-1000 <= Node.val <= 1000</li>
 * </ul>
 */
public abstract class SerializeAndDeserializeBinaryTree {

    private SerializeAndDeserializeBinaryTree() {
        // prevent instantiation from the outside of the class
    }

    interface Codec {
        // Encodes a tree to a single string.
        String serialize(TreeNode root);

        // Decodes your encoded data to tree.
        TreeNode deserialize(String data);
    }

    // Resource: https://www.youtube.com/watch?v=u4JAi2JJhI8
    // O(N) time | O(N) space
    public static class SerializeAndDeserializeBinaryTreeWithPreorderTraversal implements Codec {

        @Override
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorder(root, sb);
            return sb.toString();
        }

        private void preorder(TreeNode root, StringBuilder sb) {
            if (sb.length() > 0) {
                sb.append(",");
            }

            if (root == null) {
                sb.append("null");
                return;
            }

            sb.append(root.val);
            preorder(root.left, sb);
            preorder(root.right, sb);
        }

        @Override
        public TreeNode deserialize(String data) {
            String[] preorder = data.split(",");
            return preorder(preorder, new Index(0));
        }

        private TreeNode preorder(String[] preorder, Index idx) {
            String s = preorder[idx.val];
            if ("null".equals(s)) {
                idx.val++;
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(s));
            idx.val++;
            root.left = preorder(preorder, idx);
            root.right = preorder(preorder, idx);
            return root;
        }

        private static final class Index {
            int val;

            Index(int val) {
                this.val = val;
            }
        }
    }
}
