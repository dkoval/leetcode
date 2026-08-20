package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/distribute-elements-into-two-arrays-i/">Distribute Elements Into Two Arrays I</a>
 * <p>
 * You are given a 1-indexed array of distinct integers nums of length n.
 * <p>
 * You need to distribute all the elements of nums between two arrays arr1 and arr2 using n operations.
 * In the first operation, append nums[1] to arr1. In the second operation, append nums[2] to arr2.
 * Afterwards, in the ith operation:
 * <p>
 * If the last element of arr1 is greater than the last element of arr2, append nums[i] to arr1. Otherwise, append nums[i] to arr2.
 * <p>
 * The array result is formed by concatenating the arrays arr1 and arr2. For example, if arr1 == [1,2,3] and arr2 == [4,5,6], then result = [1,2,3,4,5,6].
 * <p>
 * Return the array result.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= n <= 50</li>
 *  <li>1 <= nums[i] <= 100</li>
 *  <li>All elements in nums are distinct.</li>
 * </ul>
 */
public interface DistributeElementsIntoTwoArrays1 {

    int[] resultArray(int[] nums);

    class DistributeElementsIntoTwoArrays1Rev1 implements DistributeElementsIntoTwoArrays1 {

        @Override
        public int[] resultArray(int[] nums) {
            final var n = nums.length;

            final var arr1 = new ArrayList<Integer>();
            final var arr2 = new ArrayList<Integer>();
            arr1.add(nums[0]);
            arr2.add(nums[1]);
            for (var i = 2; i < n; i++) {
                if (arr1.getLast() > arr2.getLast()) {
                    arr1.add(nums[i]);
                } else {
                    arr2.add(nums[i]);
                }
            }

            final var res = new int[n];
            for (var i = 0; i < n; i++) {
                if (i < arr1.size()) {
                    res[i] = arr1.get(i);
                } else {
                    res[i] = arr2.get(i - arr1.size());
                }
            }
            return res;
        }
    }
}
