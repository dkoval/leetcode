package com.github.dkoval.leetcode.challenge;


import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
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
}
