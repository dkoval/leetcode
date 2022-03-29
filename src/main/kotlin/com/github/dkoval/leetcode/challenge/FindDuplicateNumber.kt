package com.github.dkoval.leetcode.challenge

import kotlin.math.abs

/**
 * [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number)
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Constraints:
 * - 1 <= n <= 10^5
 * - nums.length == n + 1
 * - 1 <= nums(i) <= n
 * - All the integers in nums appear only once except for precisely one integer which appears two or more times
 */
interface FindDuplicateNumber {

    fun findDuplicate(nums: IntArray): Int
}

object FindDuplicateNumberByNegativeMarking : FindDuplicateNumber {

    // O(N) time | O(1) extra space, but modifies nums[]
    override fun findDuplicate(nums: IntArray): Int {
        var duplicate = -1
        for (x in nums) {
            val idx = abs(x)
            if (nums[idx] < 0) {
                duplicate = idx
                break
            }
            nums[idx] *= -1
        }

        // 2nd pass restores nums[]
        for (i in nums.indices) {
            if (nums[i] < 0) {
                nums[i] *= -1
            }
        }
        return duplicate
    }
}

object FindDuplicateNumberByAddingExtraWeight : FindDuplicateNumber {

    // O(N) time | O(1) extra space, but modifies nums[]
    override fun findDuplicate(nums: IntArray): Int {
        val n = nums.size
        for (x in nums) {
            // map x from [1 : n] range to index from [0 : n - 1] range
            val idx = x % n - 1
            // don't worry, nums[] will be restored in the 2nd pass
            nums[idx] += n
        }

        // find at which index max occurs
        var maxVal = Int.MIN_VALUE
        var maxIdx = -1
        for (i in nums.indices) {
            if (nums[i] > maxVal) {
                maxVal = nums[i]
                maxIdx = i
            }
            // restore the original value at index i
            nums[i] %= n
        }

        // map index back to number
        return maxIdx + 1
    }
}

object FindDuplicateNumberWithBinarySearch : FindDuplicateNumber {

    // O(N*logN) time | O(1) extra space
    override fun findDuplicate(nums: IntArray): Int {
        val n: Int = nums.size - 1
        var duplicate = -1

        // binary search in [1 : n] range
        var l = 1
        var r = n
        while (l <= r) {
            val mid = l + (r - l) / 2
            // count how many numbers in nums[] are <= mid
            // ok(): count > mid (there's a duplicate)
            // [F, F, ..., F, T, T, ..., T]
            //                ^ find min number x such that ok(x) is true
            val count: Int = countLessThenOrEqualTo(nums, mid)
            if (count > mid) {
                duplicate = mid
                // check if there's a better solution to the left of `mid`
                r = mid - 1
            } else {
                // every number to the left of `mid` can't be a solution
                l = mid + 1
            }
        }
        return duplicate
    }

    private fun countLessThenOrEqualTo(nums: IntArray, target: Int): Int {
        var count = 0
        for (x in nums) {
            if (x <= target) {
                count++
            }
        }
        return count
    }
}