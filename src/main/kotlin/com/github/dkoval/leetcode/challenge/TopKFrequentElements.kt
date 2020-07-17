package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Top K Frequent Elements](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/)
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Note:
 * - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * - Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * - It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * - You can return the answer in any order.
 */
object TopKFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (nums.size == k) return nums // all nums are unique

        val frequencies = mutableMapOf<Int, Int>()
        for (num in nums) {
            frequencies[num] = frequencies.getOrPut(num) { 0 } + 1
        }

        val pq = PriorityQueue<Int>(compareByDescending { num -> frequencies[num]  })
        for (num in frequencies.keys) {
            pq.add(num)
        }

        // k is always valid
        val result = IntArray(k)
        for (i in 0 until k) {
            result[i] = pq.poll()
        }
        return result
    }
}