package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/duplicate-zeros/">Duplicate Zeros</a>
 *
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
                i += 2;
            } else {
                i++;
            }
        }
    }
}
