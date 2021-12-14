package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/range-sum-of-bst/">Range Sum of BST</a>
 * <p>
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 2 * 10^4]</li>
 *  <li>1 <= Node.val <= 10^5</li>
 *  <li>1 <= low <= high <= 105</li>
 *  <li>All Node.val are unique</li>
 * </ul>
 */
public class RangeSumOfBST {

    // O(N) time | O(H), where H is the height of a BST; H = N in the worst case
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val >= low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val <= high) {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
