package com.github.dkoval.leetcode.challenge

/**
 * [Maximum XOR of Two Numbers in an Array](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3462/)
 *
 * Given a non-empty array of numbers, ```a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31```.
 *
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 */
interface MaximumXOROfTwoNumbersInArray {

    fun findMaximumXOR(nums: IntArray): Int
}

object MaximumXOROfTwoNumbersInArrayBruteForce : MaximumXOROfTwoNumbersInArray {

    // Time complexity: O(N^2)
    override fun findMaximumXOR(nums: IntArray): Int {
        var result = 0
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                result = maxOf(result, nums[i] xor nums[j])
            }
        }
        return result
    }
}