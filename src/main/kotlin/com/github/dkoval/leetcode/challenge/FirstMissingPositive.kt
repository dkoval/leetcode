package com.github.dkoval.leetcode.challenge

import kotlin.math.abs

/**
 * [First Missing Positive (Hard)](https://leetcode.com/problems/first-missing-positive/)
 *
 * Given an unsorted integer array `nums`. Return the smallest positive integer that is not present in `nums`.
 *
 * You must implement an algorithm that runs in `O(n)` time and uses `O(1)` auxiliary space.
 *
 * Constraints:
 *
 * - ```1 <= nums.length <= 1^05```
 * - ```-2^31 <= nums[i] <= 2^31 - 1```
 */
interface FirstMissingPositive {

    fun firstMissingPositive(nums: IntArray): Int
}

object FirstMissingPositiveBruteForce : FirstMissingPositive {

    override fun firstMissingPositive(nums: IntArray): Int {
        for (i in 1..nums.size) {
            var found = false
            for (num in nums) {
                if (num == i) {
                    found = true
                    break
                }
            }
            if (!found) return i
        }
        return nums.size + 1
    }
}

object FirstMissingPositiveInLinearTimeUsingHashSet : FirstMissingPositive {

    override fun firstMissingPositive(nums: IntArray): Int {
        val numsSet = nums.toSet()
        for (i in 1..nums.size) {
            if (i !in numsSet) return i
        }
        return nums.size + 1
    }
}

object FirstMissingPositiveInLinearTimeAndConstantSpaceRev1 : FirstMissingPositive {

    // Resource: https://www.youtube.com/watch?v=L1u-R_s2Mok
    override fun firstMissingPositive(nums: IntArray): Int {
        var foundOne = false
        for (num in nums) {
            if (num == 1) {
                foundOne = true
                break
            }
        }
        if (!foundOne) return 1
        if (nums.size == 1) return 2
        // convert numbers such that all of them are in 1..n range
        for (i in nums.indices) {
            if (nums[i] <= 0 || nums[i] > nums.size) {
                nums[i] = 1
            }
        }
        // make all positive numbers in the array negative to mark them visited
        for (i in nums.indices) {
            val idx = abs(nums[i]) - 1
            if (nums[idx] > 0) {
                nums[idx] *= -1
            }
        }
        // first encountered positive number's index + 1 will denote the smallest missing positive number
        for (i in nums.indices) {
            if (nums[i] > 0) return i + 1
        }
        return nums.size + 1
    }
}

object FirstMissingPositiveInLinearTimeAndConstantSpaceRev2 : FirstMissingPositive {

    // Resource: https://youtu.be/HKMzAsreCNs?si=o4XRDPV-eeEhLn_B
    override fun firstMissingPositive(nums: IntArray): Int {
        // Observation #1: the biggest number, which might be the answer is (N + 1):
        //
        // nums = [1, 2, ..., N]
        //         ^ smallest positive number, nums[i + 1] = nums[i] + 1
        //
        // Observation #2: any number <= 0 or >= N can't be ignored (don't change the answer).
        //
        // By substituting nums[i] < 0 or > N with 0, we'll be able to build a correlation between nums[i] and index:
        //
        // index = nums[i] % C - 1, nums[index] += C marks index as visited
        val c = nums.size + 1

        for (i in nums.indices) {
            if (nums[i] < 0 || nums[i] > nums.size) {
                nums[i] = 0
            }
        }

        for (x in nums) {
            val index = x % c - 1
            if (index < 0) {
                continue
            }

            if (nums[index] < c) {
                nums[index] += c
            }
        }

        for (i in nums.indices) {
            if (nums[i] < c) {
                return i + 1
            }
        }
        return c
    }
}