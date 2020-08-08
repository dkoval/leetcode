package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Path Sum III](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3417/)
 *
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
interface PathSum3 {

    fun pathSum(root: TreeNode?, sum: Int): Int
}

object PathSum3Solution1 : PathSum3 {

    override fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0
        val sumPaths = mutableMapOf(0 to 1) // how many paths are there for a certain sum
        return doPathSum(root, sum, 0, sumPaths)
    }

    private fun doPathSum(root: TreeNode?, targetSum: Int, currentSum: Int, sumPaths: MutableMap<Int, Int>): Int {
        if (root == null) return 0
        // `currentSum` is always increasing downwards in the recursion
        // and at each level we are putting the sum in the `sumPaths` map.
        // When we find that the (newSum - targetSum) exits in the map,
        // it means there is a path to get `targetSum`.
        val newSum = currentSum + root.`val`
        var count = sumPaths.getOrDefault(newSum - targetSum, 0)
        sumPaths[newSum] = sumPaths.getOrDefault(newSum, 0) + 1
        count += doPathSum(root.left, targetSum, newSum, sumPaths)
        count += doPathSum(root.right, targetSum, newSum, sumPaths)
        sumPaths[newSum] = sumPaths.getOrDefault(newSum, 0) - 1 // backtrack
        return count
    }
}

object PathSum3Solution2 : PathSum3 {

    // Resource: https://www.youtube.com/watch?v=Vam9gldRapY
    override fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0
        return pathSum(root.left, sum) + pathSum(root.right, sum) + // exclude current root
                pathSumIncludeRoot(root, sum) // include current root
    }

    private fun pathSumIncludeRoot(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0
        var count = 0
        if (root.`val` == sum) {
            count++
        }
        count += pathSumIncludeRoot(root.left, sum - root.`val`)
        count += pathSumIncludeRoot(root.right, sum - root.`val`)
        return count
    }
}