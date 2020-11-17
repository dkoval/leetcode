package com.github.dkoval.leetcode.mock;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/delete-nodes-and-return-forest/">Delete Nodes And Return Forest</a>
 * <p>
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * <p>
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 * <p>
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 */
public abstract class DeleteNodesAndReturnForest {

    public abstract List<TreeNode> delNodes(TreeNode root, int[] to_delete);

    public static class DeleteNodesAndReturnForestRecursiveBottomUp extends DeleteNodesAndReturnForest {

        @Override
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            Set<Integer> valuesToDelete = new HashSet<>();
            for (int value : to_delete) {
                valuesToDelete.add(value);
            }
            List<TreeNode> forest = new ArrayList<>();
            if (delNodes(root, valuesToDelete, forest) != null) {
                forest.add(root);
            }
            return forest;
        }

        // Deletes `root` of the tree if its value is in `valuesToDelete` set and returns null,
        // otherwise returns the original `root`
        private TreeNode delNodes(TreeNode root, Set<Integer> valuesToDelete, List<TreeNode> forest) {
            if (root == null) return null;
            // postorder traversal
            root.left = delNodes(root.left, valuesToDelete, forest);
            root.right = delNodes(root.right, valuesToDelete, forest);
            if (valuesToDelete.contains(root.val)) {
                if (root.left != null) {
                    forest.add(root.left);
                }
                if (root.right != null) {
                    forest.add(root.right);
                }
                return null;
            }
            return root;
        }
    }

    public static class DeleteNodesAndReturnForestRecursiveBottomUpWithParentRef extends DeleteNodesAndReturnForest {

        @Override
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> forest = new ArrayList<>();
            Set<Integer> toDelete = new HashSet<>();
            for (int value : to_delete) {
                toDelete.add(value);
            }
            if (!toDelete.contains(root.val)) {
                forest.add(root);
            }
            delNodes(root, null, toDelete, forest);
            return forest;
        }

        private void delNodes(TreeNode root, TreeNode parent, Set<Integer> toDelete, List<TreeNode> forest) {
            if (root == null) {
                return;
            }

            // process nodes bottom up
            delNodes(root.left, root, toDelete, forest);
            delNodes(root.right, root, toDelete, forest);

            if (toDelete.contains(root.val)) {
                if (root.left != null) {
                    forest.add(root.left);
                }
                if (root.right != null) {
                    forest.add(root.right);
                }
                // fix parent link
                if (parent != null) {
                    if (parent.left == root) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            }
        }
    }
}
