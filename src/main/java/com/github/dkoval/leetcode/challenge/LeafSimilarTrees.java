package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/leaf-similar-trees/">Leaf-Similar Trees</a>
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in each tree will be in the range [1, 200].</li>
 *  <li>Both of the given trees will have values in the range [0, 200].</li>
 * </ul>
 */
public interface LeafSimilarTrees {

    boolean leafSimilar(TreeNode root1, TreeNode root2);

    class LeafSimilarTreesDFSUsingStack implements LeafSimilarTrees {

        @Override
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leaves1 = getLeaves(root1);
            List<Integer> leaves2 = getLeaves(root2);
            return leaves1.equals(leaves2);
        }

        private List<Integer> getLeaves(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            // DFS with explicit stack
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                if (curr.left == null && curr.right == null) {
                    ans.add(curr.val);
                    continue;
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
            return ans;
        }
    }

    class LeafSimilarTreesDFSUsingRecursion implements LeafSimilarTrees {

        @Override
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> res1 = getLeaves(root1);
            List<Integer> res2 = getLeaves(root2);
            return res1.equals(res2);
        }

        private List<Integer> getLeaves(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root, ans);
            return ans;
        }

        private void dfs(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                ans.add(root.val);
                return;
            }

            dfs(root.left, ans);
            dfs(root.right, ans);
        }
    }
}
