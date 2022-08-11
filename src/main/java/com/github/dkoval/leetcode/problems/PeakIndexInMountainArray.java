package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">Peak Index in a Mountain Array</a>
 * <p>
 * Let's call an array arr a mountain if the following properties hold:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 */
public interface PeakIndexInMountainArray {

    int peakIndexInMountainArray(int[] arr);

    class PeakIndexInMountainArrayRev1 implements PeakIndexInMountainArray {

        // O(logN) time | O(1) space
        @Override
        public int peakIndexInMountainArray(int[] arr) {
            int n = arr.length;

            // in a mountain array, condition a[i] < a[i + 1] looks like:
            // [T, T, ..., T, F, F, ...F]
            //                ^ answer
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < arr[mid + 1]) {
                    // mid is not the answer
                    left = mid + 1;
                } else {
                    // mid might be the answer
                    // check if there is a better option to the left of mid
                    right = mid;
                }
            }
            return left;
        }
    }
}
