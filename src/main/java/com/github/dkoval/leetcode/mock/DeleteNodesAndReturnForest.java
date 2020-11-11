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
public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> valuesToDelete = new HashSet<>();
        for (int value : to_delete) {
            valuesToDelete.add(value);
        }
        List<TreeNode> roots = new ArrayList<>();
        if (delNodes(root, valuesToDelete, roots) != null) {
            roots.add(root);
        }
        return roots;
    }

    // Deletes `root` of the tree if its value is in `valuesToDelete` set and returns null,
    // otherwise returns the original `root`
    private TreeNode delNodes(TreeNode root, Set<Integer> valuesToDelete, List<TreeNode> roots) {
        if (root == null) return null;
        // postorder traversal
        root.left = delNodes(root.left, valuesToDelete, roots);
        root.right = delNodes(root.right, valuesToDelete, roots);
        if (valuesToDelete.contains(root.val)) {
            if (root.left != null) {
                roots.add(root.left);
            }
            if (root.right != null) {
                roots.add(root.right);
            }
            return null;
        }
        return root;
    }
}
