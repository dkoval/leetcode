package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays">Make Two Arrays Equal by Reversing Subarrays</a>
 * <p>
 * You are given two integer arrays of equal length target and arr.
 * In one step, you can select any non-empty subarray of arr and reverse it.
 * You are allowed to make any number of steps.
 * <p>
 * Return true if you can make arr equal to target or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>target.length == arr.length</li>
 *  <li>1 <= target.length <= 1000</li>
 *  <li>1 <= target[i] <= 1000</li>
 *  <li>1 <= arr[i] <= 1000</li>
 * </ul>
 */
public interface MakeTwoArraysEqualByReversingSubarrays {

    boolean canBeEqual(int[] target, int[] arr);

    class MakeTwoArraysEqualByReversingSubarraysRev1 implements MakeTwoArraysEqualByReversingSubarrays {

        @Override
        public boolean canBeEqual(int[] target, int[] arr) {
            if (arr.length != target.length) {
                return false;
            }

            // If target[] and arr[] contain exactly the same elements,
            // it's always possible to convert arr[] to target[] by revrsing
            // non-empty subarrays multiple times.
            Arrays.sort(target);
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != target[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
