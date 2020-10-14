package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/house-robber-iii/">House Robber III</a>
 * <p>
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called the "root." Besides the root, each house has one and only one parent house. After a tour,
 * the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public abstract class HouseRobber3 {

    public abstract int rob(TreeNode root);

    // Time complexity: O(N) since we visit all nodes once.
    // Space complexity: O(N) since we need to a map with the size of O(N) to store the results,
    // and O(N) space for the call stack.
    public static class HouseRobber3DRecursionWithMemoization extends HouseRobber3 {

        @Override
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // The `memo` map stores the maximum amount of money a one can rob for a certain TreeNode
            return doRob(root, new HashMap<>());
        }

        private int doRob(TreeNode root, Map<TreeNode, Integer> memo) {
            if (root == null) {
                return 0;
            }

            if (memo.containsKey(root)) {
                // already solved
                return memo.get(root);
            }

            // Option #1. Rob the current node and its grandchildren in left and right subtrees.
            int rob = root.val;
            if (root.left != null) {
                TreeNode left = root.left;
                rob += doRob(left.left, memo) + doRob(left.right, memo);
            }
            if (root.right != null) {
                TreeNode right = root.right;
                rob += doRob(right.left, memo) + doRob(right.right, memo);
            }

            // Option #2. Skip the current node and rob its left and right children.
            int notRob = 0;
            if (root.left != null) {
                notRob += doRob(root.left, memo);
            }
            if (root.right != null) {
                notRob += doRob(root.right, memo);
            }

            // store solution for the current node and return
            int maxMoney = Math.max(rob, notRob);
            memo.put(root, maxMoney);
            return maxMoney;
        }
    }

    // Time complexity: O(N) since we visit all nodes once.
    // Space complexity: O(N) since we need to a map with the size of O(N) to store the results,
    // and O(N) space for the call stack.
    public static class HouseRobber3DRecursionWithMemoizationCompacted extends HouseRobber3 {

        @Override
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int[] answer = doRob(root, new HashMap<>());
            return Math.max(answer[0], answer[1]);
        }

        private int[] doRob(TreeNode root, Map<TreeNode, int[]> memo) {
            if (root == null) {
                return new int[]{0, 0};
            }

            if (memo.containsKey(root)) {
                return memo.get(root);
            }

            int[] left = doRob(root.left, memo);
            int[] right = doRob(root.right, memo);

            // if we rob the current node, we cannot rob its children
            int rob = root.val + left[1] + right[1];

            // otherwise, choose to rob the current node's children or not
            int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            // store solution
            int[] answer = {rob, notRob};
            memo.put(root, answer);
            return answer;
        }
    }
}
