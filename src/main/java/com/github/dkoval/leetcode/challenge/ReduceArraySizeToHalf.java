package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reduce-array-size-to-the-half/">Reduce Array Size to The Half</a>
 * <p>
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
 * <p>
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= arr.length <= 10^5</li>
 *  <li>arr.length is even</li>
 *  <li>1 <= arr[i] <= 10^5</li>
 * </ul>
 */
public interface ReduceArraySizeToHalf {

    int minSetSize(int[] arr);

    // O(N*logN) time | O(N) space
    class ReduceArraySizeToHalfRev1 implements ReduceArraySizeToHalf {

        @Override
        public int minSetSize(int[] arr) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int x : arr) {
                frequencyMap.put(x, frequencyMap.getOrDefault(x, 0) + 1);
            }

            List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
            frequencies.sort(Comparator.reverseOrder());

            int n = arr.length;
            int size = n;
            int i = 0;
            while (size > n / 2) {
                size -= frequencies.get(i);
                i++;
            }
            return i;
        }
    }
}
