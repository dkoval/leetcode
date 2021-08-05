package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3838/">Path Sum II</a>
 * <p>
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 * <p>
 * A leaf is a node with no children.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 5000]</li>
 *  <li>-1000 <= Node.val <= 1000</li>
 *  <li>-1000 <= targetSum <= 1000</li>
 * </ul>
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, List<Integer> currPath, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        currPath.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                result.add(new ArrayList<>(currPath));
            }
        } else {
            pathSum(root.left, targetSum, currPath, result);
            pathSum(root.right, targetSum, currPath, result);
        }

        // backtrack
        currPath.remove(currPath.size() - 1);
    }
}
