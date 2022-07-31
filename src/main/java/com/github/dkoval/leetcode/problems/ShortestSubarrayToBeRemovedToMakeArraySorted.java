package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/">Shortest Subarray to be Removed to Make Array Sorted</a>
 * <p>
 * Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
 * <p>
 * Return the length of the shortest subarray to remove.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 10^5</li>
 *  <li>0 <= arr[i] <= 10^9</li>
 * </ul>
 */
public interface ShortestSubarrayToBeRemovedToMakeArraySorted {

    int findLengthOfShortestSubarray(int[] arr);

    // O(N) time | O(1) space
    class ShortestSubarrayToBeRemovedToMakeArraySortedRev1 implements ShortestSubarrayToBeRemovedToMakeArraySorted {

        @Override
        public int findLengthOfShortestSubarray(int[] arr) {
            int n = arr.length;

            // step #1: get the longest non-decreasing prefix by going from left to right
            // prefix = arr[0 : left]
            int left = 0;
            while (left + 1 < n && arr[left] <= arr[left + 1]) {
                left++;
            }

            // corner case: arr[] is non-decreasing
            if (left == n - 1) {
                return 0;
            }

            // step #2: get the longest non-decreasing suffix by going from right to left
            // suffix = arr[right : n - 1]
            int right = n - 1;
            while (right >= left && arr[right] >= arr[right - 1]) {
                right--;
            }

            // corner case: arr[] is strictly decreasing
            if (right == 0) {
                return n - 1;
            }

            // step #3: get the best result be concatenating elements from prefix and suffix subarrays
            // if we leave just the prefix, the length of the subarray to remove = n - left - 1
            // if we leave just the suffix, the length of the subarray to remove = right
            int ans = Math.min(n - left - 1, right);
            int i = 0;     // i is the current index in prefix, 0 <= i <= left
            int j = right; // j is the current index in suffix, right <= j <= n - 1
            while (i <= left && j < n) {
                if (arr[i] <= arr[j]) {
                    // can concatenate arr[0 : i] with arr[j : n - 1] to make the array sorted,
                    // therefore the length of the subarray to remove = (j - 1) - (i + 1) + 1 = j - i - 1
                    ans = Math.min(ans, j - i - 1);
                    i++;
                } else {
                    // arr[j] is too low, proceed to the next value >= arr[j]
                    j++;
                }
            }
            return ans;
        }
    }
}
