package com.github.dkoval.leetcode.interview.dp

/**
 * [Maximum Sum Subarray](https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/566/)
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Follow up: If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 */
interface MaximumSumSubarray {

    fun maxSubArray(nums: IntArray): Int
}

// Time complexity: O(N^2), space complexity: O(1)
object MaximumSumSubarrayBruteForce : MaximumSumSubarray {

    override fun maxSubArray(nums: IntArray): Int {
        var maxSum = Integer.MIN_VALUE
        for (i in nums.indices) {
            var currSum = 0
            for (j in i until nums.size) {
                currSum += nums[j]
                maxSum = maxOf(maxSum, currSum)
            }
        }
        return maxSum
    }
}

// Time complexity: O(N*logN)
object MaximumSumSubarrayDivideAndConquer : MaximumSumSubarray {

    // Resource: https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
    override fun maxSubArray(nums: IntArray): Int = maxSubArray(nums, 0, nums.lastIndex)

    private fun maxSubArray(nums: IntArray, start: Int, end: Int): Int {
        if (start == end) return nums[start]
        val mid = start + (end - start) / 2
        // Return the maximum of 3 possible cases:
        // - Maximum subarray sum in left half
        // - Maximum subarray sum in right half
        // - Maximum subarray sum such that the subarray crosses the midpoint
        return maxOf(
            maxSubArray(nums, start, mid),
            maxSubArray(nums, mid + 1, end),
            maxCrossingSum(nums, start, mid, end)
        )
    }

    private fun maxCrossingSum(nums: IntArray, start: Int, mid: Int, end: Int): Int {
        // We can find the crossing sum in linear time.
        // The idea is simple, find the maximum sum starting from mid-point and ending at some point on left of mid,
        // then find the maximum sum starting from mid + 1 and ending with sum point on right of mid + 1.
        // Finally, combine the two and return.
        fun maxSubarraySum(range: IntProgression): Int {
            var maxSum = Int.MIN_VALUE
            var currSum = 0
            for (i in range) {
                currSum += nums[i]
                maxSum = maxOf(maxSum, currSum)
            }
            return maxSum
        }

        val leftSum = maxSubarraySum(mid downTo start)
        val rightSum = maxSubarraySum((mid + 1)..end)
        return maxOf(leftSum + rightSum, leftSum, rightSum)
    }
}

// Time complexity: O(N), space O(1)
object MaximumSumSubarrayKadane : MaximumSumSubarray {

    override fun maxSubArray(nums: IntArray): Int {
        // DP: Kadane's algorithm
        var maxSumSoFar = nums[0]
        var bestMaxSum = nums[0]
        for (i in 1 until nums.size) {
            // 2 options to choose from:
            // - start a new contiguous subarray
            // - extend previous contiguous subarray with nums[i]
            maxSumSoFar = maxOf(nums[i], maxSumSoFar + nums[i])
            bestMaxSum = maxOf(bestMaxSum, maxSumSoFar)
        }
        return bestMaxSum
    }
}