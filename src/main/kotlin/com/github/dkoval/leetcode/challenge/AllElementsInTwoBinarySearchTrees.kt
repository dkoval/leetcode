package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [All Elements in Two Binary Search Trees](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3449/)
 *
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 */
interface AllElementsInTwoBinarySearchTrees {

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int>
}

// Space complexity: O(M + N), space complexity: O(M + N) - required to merge 2 sorted lists
object AllElementsInTwoBinarySearchTreesUsingInorderTraversalWithMerge : AllElementsInTwoBinarySearchTrees {

    override fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        // Inorder traversal of a BST generates a list sorted in ascending order
        val list1 = traverseInorder(root1)
        val list2 = traverseInorder(root2)
        return mergeSortedLists(list1, list2)
    }

    private fun traverseInorder(root: TreeNode?): List<Int> {
        fun doTraverseInorder(root: TreeNode?, result: MutableList<Int>) {
            if (root == null) return
            doTraverseInorder(root.left, result)
            result.add(root.`val`)
            doTraverseInorder(root.right, result)
        }
        return mutableListOf<Int>().also { doTraverseInorder(root, it) }
    }

    private fun mergeSortedLists(list1: List<Int>, list2: List<Int>): List<Int> {
        val result = ArrayList<Int>(list1.size + list2.size)
        var i = 0
        var j = 0
        // iterate over the smaller of 2 lists
        while (i < list1.size && j < list2.size) {
            if (list1[i] < list2[j]) {
                result.add(list1[i])
                i++
            } else {
                result.add(list2[j])
                j++
            }
        }
        // if list1 is larger, append remaining elements to the result
        while (i < list1.size) {
            result.add(list1[i])
            i++
        }
        // if list2 is larger, append remaining elements to the result
        while (j < list2.size) {
            result.add(list2[j])
            j++
        }
        return result
    }
}