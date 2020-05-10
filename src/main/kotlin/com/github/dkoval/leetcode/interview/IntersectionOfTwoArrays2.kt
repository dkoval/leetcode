package com.github.dkoval.leetcode.interview

/**
 * [Intersection of Two Arrays](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/674/)
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Note:
 * - Each element in the result should appear as many times as it shows in both arrays.
 * - The result can be in any order.
 *
 * Follow up:
 * - What if the given array is already sorted? How would you optimize your algorithm?
 * - What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * - What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
object IntersectionOfTwoArrays2 {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        var i = 0
        var j = 0
        val result = mutableListOf<Int>()
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] < nums2[j] -> i++
                nums1[i] > nums2[j] -> j++
                else -> {
                    result.add(nums1[i])
                    i++
                    j++
                }
            }
        }
        return result.toIntArray()
    }
}