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

        val counts = mutableMapOf<Int, Int>()
        for (x in nums) {
            counts[x] = counts.getOrPut(x) { 0 } + 1
        }

        val minHeap = PriorityQueue<Int>(compareBy { x -> counts[x] })
        for (x in counts.keys) {
            minHeap.offer(x)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        // k is always valid
        val ans = IntArray(k)
        for (i in k - 1 downTo 0) {
            ans[i] = minHeap.poll()
        }
        return ans
    }
}