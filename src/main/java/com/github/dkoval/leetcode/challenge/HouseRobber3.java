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

    public static class HouseRobber3DTopDownWithMemoization extends HouseRobber3 {

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

            // Option #1. Skip the current node and rob its left and right children
            int money1 = 0;
            if (root.left != null) {
                money1 += doRob(root.left, memo);
            }
            if (root.right != null) {
                money1 += doRob(root.right, memo);
            }

            // Option #2. Rob the current node and its grandchildren in left and right subtrees
            int money2 = root.val;
            if (root.left != null) {
                TreeNode left = root.left;
                money2 += doRob(left.left, memo) + doRob(left.right, memo);
            }
            if (root.right != null) {
                TreeNode right = root.right;
                money2 += doRob(right.left, memo) + doRob(right.right, memo);
            }

            // store solution for the current node and return
            int maxMoney = Math.max(money1, money2);
            memo.put(root, maxMoney);
            return maxMoney;
        }
    }
}
