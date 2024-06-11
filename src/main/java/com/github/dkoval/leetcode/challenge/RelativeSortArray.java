package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/relative-sort-array/">Relative Sort Array</a>
 * <p>
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr1.length, arr2.length <= 1000</li>
 *  <li>0 <= arr1[i], arr2[i] <= 1000</li>
 *  <li>All the elements of arr2 are distinct</li>
 *  <li>Each arr2[i] is in arr1</li>
 * </ul>
 */
public interface RelativeSortArray {

    int[] relativeSortArray(int[] arr1, int[] arr2);

    class RelativeSortArrayRev1 implements RelativeSortArray {

        @Override
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int n = arr1.length;

            Map<Integer, Integer> counts = new HashMap<>();
            for (int x : arr1) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }

            // all elements in arr2 are also in arr1
            int[] ans = new int[n];

            // elements of arr2 are distinct
            int i = 0;
            for (int x : arr2) {
                int count = counts.get(x);
                while (count-- > 0) {
                    ans[i++] = x;
                }
                counts.remove(x);
            }

            List<Map.Entry<Integer, Integer>> uniq = new ArrayList<>(counts.entrySet());
            uniq.sort(Comparator.comparingInt(Map.Entry::getKey));

            for (Map.Entry<Integer, Integer> entry : uniq) {
                int x = entry.getKey();
                int count = entry.getValue();
                while (count-- > 0) {
                    ans[i++] = x;
                }
            }
            return ans;
        }
    }
}
