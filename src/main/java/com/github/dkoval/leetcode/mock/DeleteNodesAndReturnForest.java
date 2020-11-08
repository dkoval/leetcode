package com.github.dkoval.leetcode.mock;

import com.github.dkoval.leetcode.TreeNode;

import java.util.*;

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
        if (to_delete.length == 0) {
            return Collections.singletonList(root);
        }

        Set<Integer> nodesToDelete = new HashSet<>();
        for (int val : to_delete) {
            nodesToDelete.add(val);
        }

        LinkedList<TreeNode> roots = new LinkedList<>();
        roots.add(root);

        traverse(root, root, nodesToDelete, roots);
        return roots;
    }

    private void traverse(TreeNode curr, TreeNode parent, Set<Integer> nodesToDelete, Deque<TreeNode> roots) {
        if (curr == null) {
            return;
        }

        // postorder
        traverse(curr.left, curr, nodesToDelete, roots);
        traverse(curr.right, curr, nodesToDelete, roots);

        if (!nodesToDelete.contains(curr.val)) {
            return;
        }

        // put current node's children as roots
        if (curr.left != null) {
            roots.addLast(curr.left);
        }
        if (curr.right != null) {
            roots.addLast(curr.right);
        }

        // delete current node
        if (curr == parent.left) {
            parent.left = null;
        } else if (curr == parent.right) {
            parent.right = null;
        } else {
            // special case: delete root of the entire tree
            roots.removeFirst();
        }
    }
}
