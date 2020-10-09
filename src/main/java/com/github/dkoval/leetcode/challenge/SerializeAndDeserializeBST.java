package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

public abstract class SerializeAndDeserializeBST {

    public static final Codec CODEC = new Codec();

    private SerializeAndDeserializeBST() { /* prevents instantiation from the outside */ }

    public static class Codec {

        private static final String DELIMITER = ",";

        private Codec() { /* prevents instantiation from the outside */ }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // Important fact: BST can only be constructed from preorder or postorder traversal.
            // We use postorder traversal here.
            StringBuilder result = new StringBuilder();
            postorder(root, result);
            if (result.length() > 0) {
                // remove tailing DELIMITER
                result.deleteCharAt(result.length() - 1);
            }
            return result.toString();
        }

        private void postorder(TreeNode root, StringBuilder result) {
            if (root == null) {
                return;
            }
            postorder(root.left, result);
            postorder(root.right, result);
            result.append(root.val).append(DELIMITER);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            String[] postorder = data.split(DELIMITER);
            return bstFromPostorder(postorder, 0, postorder.length - 1);
        }

        private TreeNode bstFromPostorder(String[] postorder, int start, int end) {
            if (start > end) {
                return null;
            }
            int val = Integer.parseInt(postorder[end]);
            TreeNode root = new TreeNode(val);
            int i = end;
            while (i >= start && Integer.parseInt(postorder[i]) >= val) {
                i--;
            }
            root.left = bstFromPostorder(postorder, start, i);
            root.right = bstFromPostorder(postorder, i + 1, end - 1);
            return root;
        }
    }
}
