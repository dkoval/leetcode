package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/unique-number-of-occurrences/">Unique Number of Occurrences</a>
 * <p>
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 1000</li>
 *  <li>-1000 <= arr[i] <= 1000</li>
 * </ul>
 */
public interface UniqueNumberOfOccurrences {

    boolean uniqueOccurrences(int[] arr);

    // O(N) time | O(N) space
    class UniqueNumberOfOccurrencesRev1 implements UniqueNumberOfOccurrences {

        @Override
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> occurrences = new HashMap<>();
            for (int x : arr) {
                occurrences.put(x, occurrences.getOrDefault(x, 0) + 1);
            }

            Set<Integer> seen = new HashSet<>();
            for (int occurrence : occurrences.values()) {
                if (seen.contains(occurrence)) {
                    return false;
                }
                seen.add(occurrence);
            }
            return true;
        }
    }
}
