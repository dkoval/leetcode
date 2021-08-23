package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3908/">Two Sum IV - Input is a BST</a>
 * <p>
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such
 * hat their sum is equal to the given target.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^4]</li>
 *  <li>-10^4 <= Node.val <= 10^4</li>
 *  <li>root is guaranteed to be a valid binary search tree</li>
 *  <li>-10^5 <= k <= 10^5</li>
 * </ul>
 */
public class TwoSum4InputIsBST {

    // O(N) time | O(N) space, where N is the number of nodes in a BST
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, k, new LinkedHashSet<>());
    }

    private boolean findTarget(TreeNode root, int k, Set<Integer> seen) {
        // idea: in-order traversal of a BST visits nodes by their values sorted in asc order
        if (root == null) {
            return false;
        }

        // visit left sub-tree
        boolean found = findTarget(root.left, k, seen);
        if (found) {
            return true;
        }

        // process root
        int complement = k - root.val;
        if (seen.contains(complement)) {
            return true;
        }
        seen.add(root.val);

        // visit right sub-tree
        return findTarget(root.right, k, seen);
    }
}
