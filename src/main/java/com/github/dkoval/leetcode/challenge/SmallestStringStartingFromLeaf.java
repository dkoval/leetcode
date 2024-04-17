package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/smallest-string-starting-from-leaf/">Smallest String Starting From Leaf</a>
 * <p>
 * You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
 * <p>
 * Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 * <p>
 * As a reminder, any shorter prefix of a string is lexicographically smaller.
 * <p>
 * For example, "ab" is lexicographically smaller than "aba".
 * A leaf of a node is a node that has no children.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 8500].</li>
 *  <li>0 <= Node.val <= 25</li>
 * </ul>
 */
public interface SmallestStringStartingFromLeaf {

    String smallestFromLeaf(TreeNode root);

    class SmallestStringStartingFromLeafRev1 implements SmallestStringStartingFromLeaf {

        @Override
        public String smallestFromLeaf(TreeNode root) {
            StringBuilder[] best = {null};
            dfs(root, new StringBuilder(), best);
            return best[0].toString();
        }

        private void dfs(TreeNode node, StringBuilder str, StringBuilder[] best) {
            if (node == null) {
                return;
            }

            str.append((char)('a' + node.val));

            if (node.left == null && node.right == null) {
                StringBuilder curr = new StringBuilder(str).reverse();
                if (best[0] == null || best[0].compareTo(curr) > 0) {
                    best[0] = curr;
                }
            } else {
                dfs(node.left, str, best);
                dfs(node.right, str, best);
            }

            // backtrack
            str.deleteCharAt(str.length() - 1);
        }
    }
}
