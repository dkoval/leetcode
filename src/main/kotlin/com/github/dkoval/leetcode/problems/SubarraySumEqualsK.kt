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
object SubarraySumEqualsKWithoutSpace : SubarraySumEqualsK {

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
        // sum(i, j) = sum(j, 0) - sum(i, 0)
        var count = 0
        var sum = 0
        // stores (sum[i], number of occurrences of sum[i]) pairs
        val sumOccurrences = mutableMapOf<Int, Int>().apply { this[0] = 1 }
        for (num in nums) {
            sum += num
            sumOccurrences[sum - k]?.also { numOccurrences -> count += numOccurrences }
            sumOccurrences[sum] = sumOccurrences.getOrDefault(sum, 0) + 1
        }
        return count
    }
}