package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Kth Smallest Element in a BST](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/)
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
interface KthSmallestElementInBST {

    fun kthSmallest(root: TreeNode, k: Int): Int
}

object KthSmallestElementInBSTRecursiveInorder : KthSmallestElementInBST {

    override fun kthSmallest(root: TreeNode, k: Int): Int {
        val ans = IndexAndValue(0, -1)
        inorder(root, k, ans);
        return ans.value
    }

    private data class IndexAndValue(var index: Int, var value: Int)

    // Fact: In-order traversal of a BST returns the node in ascending order.
    // Idea: Keep track of the number of nodes processed so far while traversing the BST in in-order fashion.
    // When the number of nodes processed becomes equal to k, the current node is k-th smallest.
    private fun inorder(root: TreeNode?, k: Int, ans: IndexAndValue) {
        if (root == null) {
            return
        }
        // search in the left subtree
        inorder(root.left, k, ans)
        // if the current node is k-th, return its node
        if (++ans.index == k) {
            ans.value = root.`val`
            return
        }
        // search in the right subtree
        inorder(root.right, k, ans)
    }
}