package com.github.dkoval.leetcode.challenge;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/kth-distinct-string-in-an-array/">Kth Distinct String in an Array</a>
 * <p>
 * A distinct string is a string that is present only once in an array.
 * <p>
 * Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
 * If there are fewer than k distinct strings, return an empty string "".
 * <p>
 * Note that the strings are considered in the order in which they appear in the array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= arr.length <= 1000</li>
 *  <li>1 <= arr[i].length <= 5</li>
 *  <li>arr[i] consists of lowercase English letters.</li>
 * </ul>
 */
public interface KthDistinctStringInArray {

    String kthDistinct(String[] arr, int k);

    class KthDistinctStringInArrayRev1 implements KthDistinctStringInArray {

        @Override
        public String kthDistinct(String[] arr, int k) {
            Map<String, Integer> counts = new LinkedHashMap<>();
            for (String s : arr) {
                counts.put(s, counts.getOrDefault(s, 0) + 1);
            }

            String ans = null;
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = entry.getKey();
                    if (--k == 0) {
                        break;
                    }
                }
            }
            return (k == 0) ? ans : "";
        }
    }
}
