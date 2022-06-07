package com.github.dkoval.leetcode.interview.sortingandsearching

/**
 * [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * - The number of elements initialized in nums1 and nums2 are m and n respectively.
 * - You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 */
interface MergeSortedArray {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int)
}

// O(M + N) time | O(M) space, M <= N
object MergeSortedArrayIntoLargerOneUsingExtraMSpace : MergeSortedArray {

    override fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        val tmp = nums1.copyOf(m) // copy first m elements of nums1 array
        var i = 0
        var j = 0
        var k = 0
        // merge sorted tmp and nums2 array into nums1
        while (i < m && j < n) {
            if (tmp[i] < nums2[j]) {
                nums1[k] = tmp[i++]
            } else {
                nums1[k] = nums2[j++]
            }
            k++
        }
        while (i < m) {
            nums1[k++] = tmp[i++]
        }
        while (j < n) {
            nums1[k++] = nums2[j++]
        }
    }
}

// O(M + N) time | O(1) space
object MergeSortedArrayIntoLargerOneUsingNoExtraSpace : MergeSortedArray {

    override fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        // iterate arrays from right to left since larger values appear at the end
        var i = m - 1
        var j = n - 1
        var k = m + n - 1
        while (i >= 0 && j >= 0) {
            nums1[k--] = if (nums1[i] > nums2[j]) nums1[i--] else nums2[j--]
        }
        // copy remaining elements from nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--]
        }
    }
}