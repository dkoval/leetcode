package com.github.dkoval.leetcode.problems;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-the-distance-value-between-two-arrays/">Find the Distance Value Between Two Arrays</a>
 * <p>
 * Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
 * <p>
 * The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr1.length, arr2.length <= 500</li>
 *  <li>-1000 <= arr1[i], arr2[j] <= 1000</li>
 *  <li>0 <= d <= 100</li>
 * </ul>
 */
public interface FindDistanceValueBetweenTwoArrays {

    int findTheDistanceValue(int[] arr1, int[] arr2, int d);

    class FindDistanceValueBetweenTwoArraysBinarySearch implements FindDistanceValueBetweenTwoArrays {

        @Override
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr2);
            int count = 0;
            for (int x : arr1) {
                if (isGood(arr2, x, d)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isGood(int[] arr, int target, int threshold) {
            // binary search
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (Math.abs(arr[mid] - target) <= threshold) {
                    return false;
                }
                // select interval where |arr[mid] - target| increases
                if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return true;
        }
    }
}
