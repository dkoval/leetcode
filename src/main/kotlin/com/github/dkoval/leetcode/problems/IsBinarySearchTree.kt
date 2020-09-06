package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import java.util.*

/**
 * [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 */
interface IsBinarySearchTree {

    fun isValidBST(root: TreeNode?): Boolean
}

// Time complexity: O(N^2)
object IsBinarySearchTreeRecursivelyBruteForce : IsBinarySearchTree {

    override fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        if (isSubtreeLesser(root.left, root.`val`)
            && isSubtreeGreater(root.right, root.`val`)
            && isValidBST(root.left)
            && isValidBST(root.right)
        ) return true
        return false
    }

    private fun isSubtreeLesser(root: TreeNode?, value: Int): Boolean {
        if (root == null) return true
        if (root.`val` < value
            && isSubtreeLesser(root.left, value)
            && isSubtreeLesser(root.right, value)
        ) return true
        return false
    }

    private fun isSubtreeGreater(root: TreeNode?, value: Int): Boolean {
        if (root == null) return true
        if (root.`val` > value
            && isSubtreeGreater(root.left, value)
            && isSubtreeGreater(root.right, value)
        ) return true
        return false
    }
}

// Time complexity: O(N) - since we visit each node exactly once,
// Space complexity: O(N) - since we keep up to the entire tree
object IsBinarySearchTreeRecursivelyWithRanges : IsBinarySearchTree {

    override fun isValidBST(root: TreeNode?): Boolean = doIsValidBST(root, null, null)

    private fun doIsValidBST(root: TreeNode?, minValue: Int?, maxValue: Int?): Boolean {
        if (root == null) return true

        // check for BST constraint violation: root.`val` must be in (minValue; maxValue) range
        if (minValue != null && root.`val` <= minValue
            || maxValue != null && root.`val` >= maxValue
        ) return false

        return doIsValidBST(root.left, minValue, root.`val`)
                && doIsValidBST(root.right, root.`val`, maxValue)
    }
}

// Time complexity: O(N) - since we visit each node exactly once,
// Space complexity: O(N) - to keep stack
object IsBinarySearchTreeUsingInorderTraversal : IsBinarySearchTree {

    override fun isValidBST(root: TreeNode?): Boolean {
        val stack: Deque<TreeNode> = ArrayDeque()
        var curr = root
        var prev: Int? = null
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not a BST.
            if (prev != null && curr.`val` <= prev) return false
            prev = curr.`val`
            curr = curr.right
        }
        return true
    }
}