package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/find-lucky-integer-in-an-array/">Find Lucky Integer in an Array</a>
 * <p>
 * Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
 * <p>
 * Return the largest lucky integer in the array. If there is no lucky integer return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 500</li>
 *  <li>1 <= arr[i] <= 500</li>
 * </ul>
 */
public interface FindLuckyIntegerInArray {

    int findLucky(int[] arr);

    class FindLuckyIntegerInArrayRev1 implements FindLuckyIntegerInArray {

        @Override
        public int findLucky(int[] arr) {
            final var freq = new HashMap<Integer, Integer>();

            for (var x : arr) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            var best = -1;
            for (var entry : freq.entrySet()) {
                if (entry.getKey() == entry.getValue()) {
                    best = Math.max(best, entry.getKey());
                }
            }
            return best;
        }
    }
}
