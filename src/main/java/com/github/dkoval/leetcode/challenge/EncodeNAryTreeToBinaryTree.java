package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3511/">Encode N-ary Tree to Binary Tree</a>
 * <p>
 * Design an algorithm to encode an N-ary tree into a binary tree and decode the binary tree to get the original N-ary tree.
 * An N-ary tree is a rooted tree in which each node has no more than N children.
 * Similarly, a binary tree is a rooted tree in which each node has no more than 2 children.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that an N-ary tree can be encoded to a binary tree and this binary tree can be decoded to
 * the original N-nary tree structure.
 */
public abstract class EncodeNAryTreeToBinaryTree {

    private EncodeNAryTreeToBinaryTree() { /* prevents instantiation from the outside */}

    public static class Node {
        public int val;
        public final List<Node> children;

        public Node(int val) {
            this(val, new ArrayList<>());
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static class Codec {

        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            TreeNode node = new TreeNode(root.val);
            if (!root.children.isEmpty()) {
                node.left = encode(root.children.get(0));
            }
            TreeNode sibling = node.left;
            for (int i = 1; i < root.children.size(); i++) {
                sibling.right = encode(root.children.get(i));
                sibling = sibling.right;
            }
            return node;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            Node node = new Node(root.val, new ArrayList<>());
            TreeNode sibling = root.left;
            while (sibling != null) {
                node.children.add(decode(sibling));
                sibling = sibling.right;
            }
            return node;
        }
    }
}
