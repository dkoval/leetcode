package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/valid-mountain-array/">Valid Mountain Array</a>
 * <p>
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <ul>
 *     <li>A.length >= 3</li>
 *     <li>There exists some i with 0 < i < A.length - 1 such that: A[0] < A[1] < ... A[i-1] < A[i], A[i] > A[i+1] > ... > A[A.length - 1]</li>
 * </ul>
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        int i = 0;
        // walk up
        while (i + 1 < A.length && A[i] < A[i + 1]) i++;
        // peak can't be first or last element
        if (i == 0 || i == A.length - 1) return false;
        // walk down
        while (i + 1 < A.length && A[i] > A[i + 1]) i++;
        // check if we reached the end of the array
        return i == A.length - 1;
    }
}
