package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">Unique Binary Search Trees II</a>
 * <p>
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
public interface UniqueBinarySearchTrees2 {

    List<TreeNode> generateTrees(int n);

    class UniqueBinarySearchTrees2Rev1 implements UniqueBinarySearchTrees2 {

        @Override
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            if (start > end) {
                return Collections.singletonList(null);
            }

            List<TreeNode> ans = new ArrayList<>();
            // Consider every i as the root of a BST and then repeat the process recursively for left and right subtrees
            for (int i = start; i <= end; i++) {
                List<TreeNode> lefts = generateTrees(start, i - 1);
                List<TreeNode> rights = generateTrees(i + 1, end);

                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
            return ans;
        }
    }

    class UniqueBinarySearchTrees2Rev2 implements UniqueBinarySearchTrees2 {

        @Override
        public List<TreeNode> generateTrees(int n) {
            return generate(1, n);
        }

        private List<TreeNode> generate(int start, int end) {
            if (start > end) {
                return Collections.emptyList();
            }

            // select the root node from [start : end] range
            List<TreeNode> ans = new ArrayList<>();
            for (int root = start; root <= end; root++) {
                // recursively generate all possible left and right subtrees
                List<TreeNode> leftTrees = generate(start, root - 1);
                List<TreeNode> rightTrees = generate(root + 1, end);

                if (leftTrees.isEmpty() && rightTrees.isEmpty()) {
                    ans.add(new TreeNode(root));
                } else if (leftTrees.isEmpty()) {
                    for (TreeNode right : rightTrees) {
                        ans.add(new TreeNode(root, null, right));
                    }
                } else if (rightTrees.isEmpty()) {
                    for (TreeNode left : leftTrees) {
                        ans.add(new TreeNode(root, left, null));
                    }
                } else {
                    for (TreeNode left : leftTrees) {
                        for (TreeNode right : rightTrees) {
                            ans.add(new TreeNode(root, left, right));
                        }
                    }
                }
            }
            return ans;
        }
    }
}
