package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/"> Vertical Order Traversal of a Binary Tree (Hard)</a>
 * <p>
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 * <p>
 * For each node at position (row, col), its left and right children will be at positions
 * (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 * <p>
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index
 * starting from the leftmost column and ending on the rightmost column.
 * There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 * <p>
 * Return the vertical order traversal of the binary tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 1000]</li>
 *  <li>0 <= Node.val <= 1000</li>
 * </ul>
 */
public interface VerticalOrderTraversalOfBinaryTree {

    List<List<Integer>> verticalTraversal(TreeNode root);

    class VerticalOrderTraversalOfBinaryTreeRev2 implements VerticalOrderTraversalOfBinaryTree {

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            // holds column index -> elements in this column in top-to-bottom order;
            // note that column indices are maintained sorted in asc order
            Map<Integer, List<RowVal>> cols = new TreeMap<>();
            Queue<TreeNodeWrapper> q = new ArrayDeque<>();
            q.offer(new TreeNodeWrapper(root, 0, 0));
            while (!q.isEmpty()) {
                int n = q.size();
                while (n-- > 0) {
                    TreeNodeWrapper curr = q.poll();
                    cols.computeIfAbsent(curr.col, key -> new ArrayList<>())
                            .add(new RowVal(curr.row, curr.node.val));

                    if (curr.node.left != null) {
                        q.offer(new TreeNodeWrapper(curr.node.left, curr.row + 1, curr.col - 1));
                    }

                    if (curr.node.right != null) {
                        q.offer(new TreeNodeWrapper(curr.node.right, curr.row + 1, curr.col + 1));
                    }
                }
            }

            Comparator<RowVal> cmp = (a, b) -> (a.row == b.row) ? Integer.compare(a.val, b.val) : Integer.compare(a.row, b.row);

            List<List<Integer>> ans = new ArrayList<>();
            for (List<RowVal> col : cols.values()) {
                col.sort(cmp);

                List<Integer> xs = new ArrayList<>();
                for (RowVal item : col) {
                    xs.add(item.val);
                }
                ans.add(xs);
            }
            return ans;
        }

        private static class TreeNodeWrapper {
            final TreeNode node;
            final int row;
            final int col;

            TreeNodeWrapper(TreeNode node, int row, int col) {
                this.node = node;
                this.row = row;
                this.col = col;
            }
        }

        private static class RowVal {
            final int row;
            final int val;

            RowVal(int row, int val) {
                this.row = row;
                this.val = val;
            }
        }
    }
}
