package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
interface BinaryTreeInorderTraversal {

    fun inorderTraversal(root: TreeNode?): List<Int>
}

object BinaryTreeInorderTraversalRecursively : BinaryTreeInorderTraversal {

    override fun inorderTraversal(root: TreeNode?): List<Int> {
        fun doInorderTraversal(root: TreeNode?, result: MutableList<Int>) {
            if (root == null) return
            doInorderTraversal(root.left, result)
            result.add(root.`val`)
            doInorderTraversal(root.right, result)
        }
        return mutableListOf<Int>().also { doInorderTraversal(root, it) }
    }
}

object BinaryTreeInorderTraversalIterUsingStack : BinaryTreeInorderTraversal {

    override fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        var curr = root
        val s: Deque<TreeNode> = ArrayDeque()
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr)
                curr = curr.left
            }
            val node = s.pop()
            result.add(node.`val`)
            curr = node.right
        }
        return result
    }
}