package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3792/">Count of Smaller Numbers After Self</a>
 * <p>
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-10^4 <= nums[i] <= 10^4</li>
 * </ul>
 */
public class CountOfSmallerNumbersAfterSelf {

    private static class IndexedValue {
        final int index;
        final int value;

        IndexedValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] counts = new Integer[nums.length];
        Arrays.fill(counts, 0);

        IndexedValue[] indexedNums = index(nums);
        countingMergeSort(indexedNums, 0, nums.length - 1, counts);
        return Arrays.asList(counts);
    }

    private IndexedValue[] index(int[] nums) {
        IndexedValue[] result = new IndexedValue[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = new IndexedValue(i, nums[i]);
        }
        return result;
    }

    private void countingMergeSort(IndexedValue[] nums, int start, int end, Integer[] counts) {
        if (start >= end) {
            return;
        }

        // Divide step
        int mid = start + (end - start) / 2;

        // Conquer step
        countingMergeSort(nums, start, mid, counts);
        countingMergeSort(nums, mid + 1, end, counts);

        // At this stage, nums[start : mid] and nums[mid + 1 : start] sub-arrays are sorted.
        // Count pairs such that nums[i] > nums[j].
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i].value > nums[j].value) {
                j++;
            }
            counts[nums[i].index] += j - mid - 1;
        }

        // Combine step
        merge(nums, start, mid, end);
    }

    // O(N) time | O(1) space, where N = end - start + 1
    private void merge(IndexedValue[] nums, int start, int mid, int end) {
        int n = end - start + 1;
        IndexedValue[] tmp = new IndexedValue[n];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            tmp[k++] = (nums[i].value < nums[j].value) ? nums[i++] : nums[j++];
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= end) {
            tmp[k++] = nums[j++];
        }

        System.arraycopy(tmp, 0, nums, start, n);
    }
}
