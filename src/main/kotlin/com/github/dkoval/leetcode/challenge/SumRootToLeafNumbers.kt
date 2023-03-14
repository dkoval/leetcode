package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 * Constraints:
 *
 * - The number of nodes in the tree is in the range ```[1, 1000]```.
 * - 0 <= Node.val <= 9
 * - The depth of the tree will not exceed 10.
 */
object SumRootToLeafNumbers {

    fun sumNumbers(root: TreeNode?): Int = dfs(root, 0)

    private fun dfs(root: TreeNode?, x: Int): Int {
        if (root == null) {
            return 0
        }

        val y = x * 10 + root.`val`
        if (root.left == null && root.right == null) {
            return y
        }

        return dfs(root.left, y) + dfs(root.right, y)
    }
}