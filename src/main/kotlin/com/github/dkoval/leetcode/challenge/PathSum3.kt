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

object PathSum3BruteForce : PathSum3 {

    // Resources:
    // https://leetcode.com/problems/path-sum-iii/discuss/91892/Python-solution-with-detailed-explanation
    // https://www.youtube.com/watch?v=Vam9gldRapY
    //
    // The simplest solution is to traverse each node (preorder traversal) and then
    // find all paths which sum to the target using this node as root.
    // The worst case complexity for this method is N^2.
    // If we have a balanced tree, we have the recurrence: T(N) = N + 2T(N/2).
    // This is the merge sort recurrence and suggests NlogN.
    override fun pathSum(root: TreeNode?, sum: Int): Int =
        if (root != null) {
            pathSumIncludeRoot(root, sum) + // include current root
                    pathSum(root.left, sum) + pathSum(root.right, sum) // exclude current root
        } else {
            0
        }

    private fun pathSumIncludeRoot(root: TreeNode?, sum: Int): Int =
        if (root != null) {
            var count = if (root.`val` == sum) 1 else 0
            count += pathSumIncludeRoot(root.left, sum - root.`val`)
            count += pathSumIncludeRoot(root.right, sum - root.`val`)
            count
        } else {
            0
        }
}

object PathSum3HashMap : PathSum3 {

    private class IntHolder(var value: Int)

    // Resource: https://leetcode.com/problems/path-sum-iii/discuss/91892/Python-solution-with-detailed-explanation
    //
    // A more efficient implementation uses the Two Sum idea. It uses a hash table (extra memory of order N).
    // With more space, it gives us an O(N) complexity.
    override fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0
        val sumPaths = mutableMapOf(0 to 1) // how many paths are there for a certain sum
        val result = IntHolder(0)
        doPathSum(root, sum, 0, sumPaths, result)
        return result.value
    }

    private fun doPathSum(
        root: TreeNode?,
        targetSum: Int,
        currentSum: Int,
        sumPaths: MutableMap<Int, Int>,
        result: IntHolder
    ) {
        if (root == null) return
        // `currentSum` is always increasing downwards in the recursion
        // and at each level we are putting the sum in the `sumPaths` map.
        // When we find that the (newSum - targetSum) exits in the map,
        // it means there is a path to get `targetSum`.
        val newSum = currentSum + root.`val`
        val diff = newSum - targetSum
        sumPaths[diff]?.also { result.value += it }
        // recurse
        sumPaths[newSum] = sumPaths.getOrDefault(newSum, 0) + 1
        doPathSum(root.left, targetSum, newSum, sumPaths, result)
        doPathSum(root.right, targetSum, newSum, sumPaths, result)
        // backtrack because we do not want the same sum on a different path affect the result
        sumPaths[newSum] = sumPaths.getOrDefault(newSum, 0) - 1
    }
}