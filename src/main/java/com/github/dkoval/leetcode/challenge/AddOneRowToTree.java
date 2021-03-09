package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3666/">Add One Row to Tree</a>
 * <p>
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d.
 * The root node is at depth 1.
 * <p>
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
 * create two tree nodes with value v as N's left subtree root and right subtree root.
 * And N's original left subtree should be the left subtree of the new left subtree root,
 * its original right subtree should be the right subtree of the new right subtree root.
 * If depth d is 1 that means there is no depth d-1 at all,
 * then create a tree node with value v as the new root of the whole original tree,
 * and the original tree is the new root's left subtree.
 */
public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        int depth = 1;
        Queue<TreeNode> targetLevel = new LinkedList<>(); // will keep nodes from level d - 1
        targetLevel.offer(root);
        while (depth < d - 1) {
            int size = targetLevel.size();
            while (size-- > 0) {
                TreeNode node = targetLevel.poll();
                if (node.left != null) {
                    targetLevel.offer(node.left);
                }
                if (node.right != null) {
                    targetLevel.offer(node.right);
                }
            }
            depth++;
        }

        while (!targetLevel.isEmpty()) {
            TreeNode node = targetLevel.poll();

            TreeNode tmp = node.left;
            node.left = new TreeNode(v);
            node.left.left = tmp;

            tmp = node.right;
            node.right = new TreeNode(v);
            node.right.right = tmp;
        }

        return root;
    }
}
