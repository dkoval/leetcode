package com.github.dkoval.leetcode.problems

/**
 * [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays
 * whose sum equals to k.
 */
interface SubarraySumEqualsK {

    fun subarraySum(nums: IntArray, k: Int): Int
}

// Time complexity: O(N^2). We need to consider every subarray possible.
// Space complexity: O(1). Constant space is used.
object SubarraySumEqualsKBruteForce : SubarraySumEqualsK {

    override fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in nums.indices) {
            var sum = 0
            for (j in i..nums.lastIndex) {
                sum += nums[j]
                if (sum == k) count++
            }
        }
        return count
    }
}

// Time complexity: O(N). The entire nums array is traversed only once.
// Space complexity: O(N). Hashmap can contain upto N distinct entries in the worst case.
object SubarraySumEqualsKUsingHashMap : SubarraySumEqualsK {

    override fun subarraySum(nums: IntArray, k: Int): Int {
        // Prefix sum of first i elements of nums, i.e.
        // sum(nums[0 : i]) = nums[0] + nums[1] + ... + nums[i]
        var sum = 0

        // The below map stores (sum[i] -> number of occurrences of sum[i]) pairs.
        // The reason for counting occurrences of a prefix sum is because nums[i] can be negative, therefore
        // we can have multiple prefixes that sum up to the same value, for example:
        // nums = [1, -1, 1, ...], sum([1]) = sum([1, -1, 1]) = 1
        val sumCounts = mutableMapOf<Int, Int>()
        sumCounts[0] = 1

        // sum(nums[i : j]) = sum(nums[0 : j]) - sum(nums[0 : i - 1])
        var ans = 0
        for (num in nums) {
            sum += num

            // Can we chop off x first elements from the current prefix to make sum == k?
            val complementSum = sum - k
            if (complementSum in sumCounts) {
                ans += sumCounts[complementSum]!!
            }

            sumCounts[sum] = (sumCounts[sum] ?: 0) + 1
        }
        return ans
    }
}