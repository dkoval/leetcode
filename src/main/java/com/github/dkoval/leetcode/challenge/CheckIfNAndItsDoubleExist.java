package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/check-if-n-and-its-double-exist/">Check If N and Its Double Exist</a>
 * <p>
 * Given an array arr of integers, check if there exist two indices i and j such that :
 * <ul>
 *  <li>i != j</li>
 *  <li>0 <= i, j < arr.length</li>
 *  <li>arr[i] == 2 * arr[j]</li>
 * </ul>
 * Constraints:
 * <ul>
 *  <li>2 <= arr.length <= 500</li>
 *  <li>-10^3 <= arr[i] <= 10^3</li>
 * </ul>
 */
public interface CheckIfNAndItsDoubleExist {

    boolean checkIfExist(int[] arr);

    class CheckIfNAndItsDoubleExistRev1 implements CheckIfNAndItsDoubleExist {

        @Override
        public boolean checkIfExist(int[] arr) {
            var seen = new HashSet<Integer>();
            for (var x : arr) {
                if ((Math.abs(x) % 2 == 0 && seen.contains(x / 2)) || seen.contains(x * 2)) {
                    return true;
                }
                seen.add(x);
            }
            return false;
        }
    }
}
