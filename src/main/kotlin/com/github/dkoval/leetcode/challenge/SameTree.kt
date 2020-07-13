package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Same Tree](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3389/)
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
interface SameTree {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean
}

object SameTreeRecursive: SameTree {

    override fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        return p.`val` == q.`val` &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right)
    }
}

object SameTreeIter: SameTree {

    override fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (!p.equalTo(q)) return false

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
        p.equalTo(q) && p?.left.equalTo(q?.left) && p?.right.equalTo(q?.right)

    private fun TreeNode?.equalTo(that: TreeNode?): Boolean {
        if (this == null && that == null) return true
        if (this == null || that == null) return false
        return `val` == that.`val`
    }
}