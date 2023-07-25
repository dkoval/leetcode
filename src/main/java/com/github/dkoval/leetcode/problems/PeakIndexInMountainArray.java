package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">Peak Index in a Mountain Array</a>
 * <p>
 * Let's call an array arr a mountain if the following properties hold:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * <ul>
 *  <li>arr[0] < arr[1] < ... arr[i-1] < arr[i]</li>
 *  <li>arr[i] > arr[i+1] > ... > arr[arr.length - 1]</li>
 * </ul>
 * Given an integer array arr that is guaranteed to be a mountain, return any i such that
 * arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= arr.length <= 10^5</li>
 *  <li>0 <= arr[i] <= 10^6</li>
 *  <li>arr is guaranteed to be a mountain array.</li>
 * </ul>
 */
public interface PeakIndexInMountainArray {

    int peakIndexInMountainArray(int[] arr);

    // O(logN) time | O(1) space
    class PeakIndexInMountainArrayRev1 implements PeakIndexInMountainArray {

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

    // O(logN) time | O(1) space
    class PeakIndexInMountainArrayRev2 implements PeakIndexInMountainArray {

        @Override
        public int peakIndexInMountainArray(int[] arr) {
            int n = arr.length;

            // n >= 3
            int left = 1;
            int right = n - 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] < arr[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
