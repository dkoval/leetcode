package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference/">Minimum Absolute Difference</a>
 * <p>
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * <p>
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * <ul>
 *  <li>a, b are from arr</li>
 *  <li>a < b</li>
 *  <li>b - a equals to the minimum absolute difference of any two elements in arr</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= arr.length <= 10^5</li>
 *  <li>-10^6 <= arr[i] <= 10^6</li>
 * </ul>
 */
public class MinimumAbsoluteDifference {

    // O(N*logN) time | O(1) extra space
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        // 1st pass - find the minimum absolute difference
        int minDiff = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        // 2nd pass - collect all pairs of elements with the minimum absolute difference
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }
}
