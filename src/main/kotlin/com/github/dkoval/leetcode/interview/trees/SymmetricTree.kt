package com.github.dkoval.leetcode.interview.trees

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Follow up: Solve it both recursively and iteratively.
 *
 * Constraints:
 *
 * - The number of nodes in the tree is in the range ```[1, 1000]```.
 * - -100 <= Node.val <= 100
 */
interface SymmetricTree {

    fun isSymmetric(root: TreeNode?): Boolean
}

// Time complexity : O(N) because we traverse the entire input tree once.
// Space complexity : The number of recursive calls is bound by the height of the tree.
// In the worst case, the tree is linear and the height is in O(N).
// Therefore, space complexity due to recursive calls on the stack is O(N) in the worst case.
object SymmetricTreeRecursively : SymmetricTree {

    override fun isSymmetric(root: TreeNode?): Boolean {
        // A tree is symmetric if the left subtree is a mirror reflection of the right subtree
        if (root == null) return true
        return isMirror(root.left, root.right)
    }

    private fun isMirror(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null && root2 == null) return true
        if (root1 == null || root2 == null) return false
        return (root1.`val` == root2.`val`)
                && isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left)
    }
}

// Time complexity : O(N) because we traverse the entire input tree once.
// Space complexity : There is additional space required for the search queue.
// In the worst case, we have to insert O(N) in the queue. Therefore, space complexity is O(N).
object SymmetricTreeIterUsingQueue : SymmetricTree {

    override fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        if (root.left == null && root.right == null) return true
        return doIsSymmetric(root.left, root.right)
    }

    private fun doIsSymmetric(root1: TreeNode?, root2: TreeNode?): Boolean {
        val q: Queue<TreeNode?> = ArrayDeque()
        q.offer(root1)
        q.offer(root2)
        while (!q.isEmpty()) {
            // Each two consecutive nodes in the queue should be equal,
            // and their subtrees a mirror of each other
            val t1 = q.poll()
            val t2 = q.poll()
            if (t1 == null && t2 == null) continue
            if (t1 == null || t2 == null) return false
            if (t1.`val` != t2.`val`) return false
            // Note: the order of insertions matters for the algorithm to work
            q.offer(t1.left)
            q.offer(t2.right)
            q.offer(t1.right)
            q.offer(t2.left)
        }
        return true
    }
}