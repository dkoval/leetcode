package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3920/">Verify Preorder Serialization of a Binary Tree</a>
 * <p>
 * One way to serialize a binary tree is to use preorder traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as '#'.
 * <p>
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
 * <p>
 * Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
 * <p>
 * It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid.
 * <p>
 * For example, it could never contain two consecutive commas, such as "1,,3".
 * Note: You are not allowed to reconstruct the tree.
 */
public class VerifyPreorderSerializationOfBinaryTree {

    private static class Status {
        boolean ok;
        int index;

        Status(boolean ok, int index) {
            this.ok = ok;
            this.index = index;
        }
    }

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Status status = new Status(true, 0);
        preorder(nodes, status);
        return status.ok && (status.index == nodes.length);
    }

    private void preorder(String[] nodes, Status status) {
        if (status.index >= nodes.length) {
            status.ok = false;
            return;
        }

        if (nodes[status.index].equals("#")) {
            status.index++;
            return;
        }

        status.index++;
        preorder(nodes, status);
        preorder(nodes, status);
    }
}
