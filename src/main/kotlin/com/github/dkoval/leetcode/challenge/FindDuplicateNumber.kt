package com.github.dkoval.leetcode.challenge

import kotlin.math.abs

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
        val n = nums.size - 1

        // binary search the answer in [1 : n] range
        var left = 1
        var right = n
        while (left < right) {
            val mid = left + (right - left) / 2
            // count how many numbers in nums[] are <= mid
            // if count > mid, there's a duplicate
            // [F, F, ..., F, T, T, ..., T]
            //                ^ find min number x such that ok(x) is true
            if (countLessThanOrEqualTo(nums, mid) > mid) {
                // mid might be the answer
                // check if there's a better solution to the left of `mid`
                right = mid
            } else {
                // every number to the left of `mid` can't be the answer
                left = mid + 1
            }
        }
        return left
    }

    private fun countLessThanOrEqualTo(nums: IntArray, target: Int): Int {
        var count = 0
        for (x in nums) {
            if (x <= target) {
                count++
            }
        }
        return count
    }
}