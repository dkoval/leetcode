package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Same Tree](https://leetcode.com/problems/same-tree/)
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Constraints:
 *
 * - The number of nodes in both trees is in the range ```[0, 100]```.
 * - -10^4 <= Node.val <= 10^4
 */
interface SameTree {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean
}

object SameTreeRecursive : SameTree {

    override fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        return p.`val` == q.`val` &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right)
    }
}

object SameTreeIter : SameTree {

    override fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (!p.sameAs(q)) return false

        val q1: Queue<TreeNode> = LinkedList()
        p?.also { q1.add(it) }

        val q2: Queue<TreeNode> = LinkedList()
        q?.also { q2.add(it) }

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size != q2.size) return false
            repeat(q1.size) {
                val n1 = q1.poll()
                val n2 = q2.poll()
                if (!isSameNode(n1, n2)) {
                    return false
                } else {
                    n1.left?.also { q1.add(it) }
                    n1.right?.also { q1.add(it) }
                    n2.left?.also { q2.add(it) }
                    n2.right?.also { q2.add(it) }
                }
            }
        }
        return true
    }

    private fun isSameNode(p: TreeNode?, q: TreeNode?): Boolean =
        p.sameAs(q) && p?.left.sameAs(q?.left) && p?.right.sameAs(q?.right)

    private fun TreeNode?.sameAs(that: TreeNode?): Boolean {
        if (this == null && that == null) return true
        if (this == null || that == null) return false
        return `val` == that.`val`
    }
}