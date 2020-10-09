package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class SerializeAndDeserializeBST {

    public static final Codec CODEC = new Codec();

    private SerializeAndDeserializeBST() { /* prevents instantiation from the outside */ }

    public static class Codec {

        private static final String DELIMITER = ",";

        private Codec() { /* prevents instantiation from the outside */ }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
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
            Deque<Integer> nums = new ArrayDeque<>();
            for (String num : postorder) {
                nums.add(Integer.parseInt(num));
            }
            return bstFromPostorder(nums, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode bstFromPostorder(Deque<Integer> nums, int lower, int upper) {
            if (nums.isEmpty()) {
                return null;
            }
            int val = nums.getLast();
            if (val < lower || val > upper) {
                return null;
            }
            nums.removeLast();
            TreeNode root = new TreeNode(val);
            root.right = bstFromPostorder(nums, val, upper);
            root.left = bstFromPostorder(nums, lower, val);
            return root;
        }
    }
}
