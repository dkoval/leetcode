package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from [Wikipedia](http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees):
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level
 * are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.
 *
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[0, 5 * 10^4]`.
 * - 0 <= Node.val <= 5 * 10^4
 * - The tree is guaranteed to be complete.
 */
object CountCompleteTreeNodes {

    // Resources:
    // https://www.youtube.com/watch?v=i_r2uKbwHCU
    // https://www.youtube.com/watch?v=4wPlA_InnGY
    //
    // Complexity analysis:
    // It takes logN time to calculate the height of a tree. We calculate heights at most H = logN times.
    // Therefore, in total it takes O(H * logN) = O(logN * logN) time.
    // O(H) = O(logN) space is required for the call stack.
    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        // check if a given tree is a full binary tree
        val lh = height(root) { it.left }
        val rh = height(root) { it.right }
        if (lh == rh) {
            // the number of nodes in a full binary tree = 2^h - 1
            return (1 shl lh) - 1
        }

        // recursively call countNodes() on smaller trees
        return 1 + countNodes(root.left) + countNodes(root.right)
    }

    private fun height(root: TreeNode?, onNext: (TreeNode) -> TreeNode?): Int {
        var curr = root
        var height = 0
        while (curr != null) {
            height++
            curr = onNext(curr)
        }
        return height
    }
}