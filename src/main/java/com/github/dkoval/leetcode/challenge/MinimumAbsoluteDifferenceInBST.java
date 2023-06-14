package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">Minimum Absolute Difference in BST</a>
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [2, 10^4].</li>
 *  <li>0 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface MinimumAbsoluteDifferenceInBST {

    int getMinimumDifference(TreeNode root);

    // O(N) time | O(N) space
    class MinimumAbsoluteDifferenceInBSTRev1 implements MinimumAbsoluteDifferenceInBST {

        @Override
        public int getMinimumDifference(TreeNode root) {
            // inorder traversal of a BST visits nodes
            // in increasing order of their values
            List<Integer> inorder = inorder(root);
            if (inorder.isEmpty()) {
                return 0;
            }

            int best = Integer.MAX_VALUE;
            for (int i = 1; i < inorder.size(); i++) {
                best = Math.min(best, inorder.get(i) - inorder.get(i - 1));
            }
            return best;
        }

        private List<Integer> inorder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> ans = new ArrayList<>();
            doInorder(root, ans);
            return ans;
        }

        private void doInorder(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            doInorder(root.left, ans);
            ans.add(root.val);
            doInorder(root.right, ans);
        }
    }

    // O(N) time | O(N) space
    class MinimumAbsoluteDifferenceInBSTRev2 implements MinimumAbsoluteDifferenceInBST {

        @Override
        public int getMinimumDifference(TreeNode root) {
            // inorder traversal of a BST visits nodes
            // in increasing order of their values
            TreeInfo info = new TreeInfo();
            inorder(root, info);
            return info.best;
        }

        private void inorder(TreeNode root, TreeInfo info) {
            if (root == null) {
                return;
            }

            inorder(root.left, info);

            // processing step
            int curr = root.val;
            // 0 <= Node.val <= 10^5
            if (info.prev >= 0) {
                info.best = Math.min(info.best, curr - info.prev);
            }
            info.prev = curr;

            inorder(root.right, info);
        }

        private static class TreeInfo {
            int prev = -1;
            int best = Integer.MAX_VALUE;
        }
    }
}
