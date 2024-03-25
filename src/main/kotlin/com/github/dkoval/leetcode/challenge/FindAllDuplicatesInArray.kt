package com.github.dkoval.leetcode.challenge

import kotlin.math.abs

/**
 * [Find All Duplicates in an Array](https://leetcode.com/problems/find-all-duplicates-in-an-array/)
 *
 * Given an integer array `nums` of length `n` where all the integers of `nums` are in the range `[1, n]`
 * and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in `O(n)` time and uses only constant extra space.
 *
 * Constraints:
 * - ```n == nums.length```
 * - ```1 <= n <= 10^5```
 * - ```1 <= nums[i] <= n```
 * - Each element in `nums` appears once or twice.
 */
interface FindAllDuplicatesInArray {
    fun findDuplicates(nums: IntArray): List<Int>
}

object FindAllDuplicatesInArrayRev1 : FindAllDuplicatesInArray {

    // O(N) time | O(1) space
    // Resource: https://www.youtube.com/watch?v=8ci8WfQ6cns
    override fun findDuplicates(nums: IntArray): List<Int> {
        // integers of nums are in [1, n] range, whereas array indices are in [0, n - 1] range,
        // meaning that nums[i] <=> index bijection can be built, i.e.
        // index = nums[i] - 1 <=> nums[i] = index + 1.
        // Then use negative marking to denote visited indices.
        val ans = mutableListOf<Int>()
        for (x in nums) {
            val index = abs(x) - 1
            if (nums[index] > 0) {
                // encountered index for the 1st time, mark
                nums[index] *= -1
            } else {
                // encountered index for the 2nd time, add to the result
                ans.add(index + 1)
            }
        }
        return ans
    }
}