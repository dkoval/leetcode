package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInBSTIterativeInorder implements KthSmallestElementInBST {

    @Override
    public int kthSmallest(@NotNull TreeNode root, int k) {
        // iterative inorder traversal using stack:
        // inorder(root.left)
        // process(root)
        // inorder(root.right)
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (--k == 0) {
                return node.val;
            }

            node = node.right;
        }
    }
}
