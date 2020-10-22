package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3503/">Search in a Sorted Array of Unknown Size</a>
 * <p>
 * Given an integer array sorted in ascending order, write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1. However, the array size is unknown to you.
 * You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of
 * the array at index k (0-indexed).
 * <p>
 * You may assume all integers in the array are less than 10000, and if you access the array out of bounds,
 * ArrayReader.get will return 2147483647.
 */
public class SearchInSortedArrayOfUnknownSize {

    interface ArrayReader {
        int get(int index);
    }

    // Time complexity: O(logT) where TT is an index of target value.
    // Space complexity: O(1)
    public int search(ArrayReader reader, int target) {
        // define search boundaries
        int lo = 0, hi = 1;
        while (reader.get(hi) < target) {
            // Left boundary could be moved to the right, and the right boundary should be extended.
            // To keep logarithmic time complexity, let's extend it twice as far.
            lo = hi + 1;
            hi *= 2;
        }
        // perform binary search
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int value = reader.get(mid);
            if (value < target) {
                lo = mid + 1;
            } else if (value > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
