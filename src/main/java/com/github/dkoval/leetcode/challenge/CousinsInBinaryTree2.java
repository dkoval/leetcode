package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/cousins-in-binary-tree-ii/">Cousins in Binary Tree II</a>
 * <p>
 * Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 * <p>
 * Return the root of the modified tree.
 * <p>
 * Note that the depth of a node is the number of edges in the path from the root node to it.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^5].</li>
 *  <li>1 <= Node.val <= 10^4</li>
 * </ul>
 */
public interface CousinsInBinaryTree2 {

    TreeNode replaceValueInTree(TreeNode root);

    class CousinsInBinaryTree2Rev1 implements CousinsInBinaryTree2 {

        @Override
        public TreeNode replaceValueInTree(TreeNode root) {
            int currLevelSum = root.val;
            Queue<TreeNodeInfo> q = new ArrayDeque<>();
            q.offer(new TreeNodeInfo(root, root.val));
            while (!q.isEmpty()) {
                int nextLevelSum = 0;
                int size = q.size();
                while (size-- > 0) {
                    TreeNodeInfo node = q.poll();
                    node.self.val = currLevelSum - node.siblingsSum;

                    // siblingsSum = sum of child values
                    int siblingsSum = 0;
                    if (node.self.left != null) {
                        siblingsSum += node.self.left.val;
                    }

                    if (node.self.right != null) {
                        siblingsSum += node.self.right.val;
                    }

                    // the next level of BFS
                    nextLevelSum += siblingsSum;
                    if (node.self.left != null) {
                        q.offer(new TreeNodeInfo(node.self.left, siblingsSum));
                    }

                    if (node.self.right != null) {
                        q.offer(new TreeNodeInfo(node.self.right, siblingsSum));
                    }
                }
                currLevelSum = nextLevelSum;
            }
            return root;
        }

        private static class TreeNodeInfo {
            TreeNode self;
            int siblingsSum;

            TreeNodeInfo(TreeNode self, int siblingsSum) {
                this.self = self;
                this.siblingsSum = siblingsSum;
            }
        }
    }

    class CousinsInBinaryTree2Rev2 implements CousinsInBinaryTree2 {

        @Override
        public TreeNode replaceValueInTree(TreeNode root) {
            List<Integer> levelSums = getLevelSums(root);
            traverse(root, root.val, 0, levelSums);
            return root;
        }

        private List<Integer> getLevelSums(TreeNode root) {
            // BFS
            List<Integer> levelSums = new ArrayList<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int levelSum = 0;
                int size = q.size();
                while (size-- > 0) {
                    TreeNode node = q.poll();
                    levelSum += node.val;

                    if (node.left != null) {
                        q.offer(node.left);
                    }

                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
                levelSums.add(levelSum);
            }
            return levelSums;
        }

        private void traverse(TreeNode node, int siblingsSum, int depth, List<Integer> levelSums) {
            if (node == null) {
                return;
            }

            node.val = levelSums.get(depth) - siblingsSum;

            int newSiblingsSum = 0;
            if (node.left != null) {
                newSiblingsSum += node.left.val;
            }

            if (node.right != null) {
                newSiblingsSum += node.right.val;
            }

            traverse(node.left, newSiblingsSum, depth + 1, levelSums);
            traverse(node.right, newSiblingsSum, depth + 1, levelSums);
        }
    }
}
