package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/trim-a-binary-search-tree/">Trim a Binary Search Tree</a>
 * <p>
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high,
 * trim the tree so that all its elements lies in [low, high].
 * Trimming the tree should not change the relative structure of the elements that will remain in the tree
 * (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
 * <p>
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree in the range [1, 10^4]</li>
 *  <li>0 <= Node.val <= 10^4</li>
 *  <li>The value of each node in the tree is unique</li>
 *  <li>root is guaranteed to be a valid binary search tree</li>
 *  <li>0 <= low <= high <= 10^4</li>
 * </ul>
 */
public class TrimBST {

    // O(N) time | O(H) space, where H is the height of the tree
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
