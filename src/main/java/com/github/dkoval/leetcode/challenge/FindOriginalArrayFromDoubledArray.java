package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-original-array-from-doubled-array/">Find Original Array From Doubled Array</a>
 * <p>
 * An integer array original is transformed into a doubled array changed by appending twice the value of every element in original,
 * and then randomly shuffling the resulting array.
 * <p>
 * Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array.
 * The elements in original may be returned in any order.
 */
public interface FindOriginalArrayFromDoubledArray {

    int[] findOriginalArray(int[] changed);

    // O(N*logN) time | O(N) space
    class FindOriginalArrayFromDoubledArrayUsingSorting implements FindOriginalArrayFromDoubledArray {

        @Override
        public int[] findOriginalArray(int[] changed) {
            int n = changed.length;
            if (n % 2 != 0) {
                return new int[0];
            }

            List<Integer> ans = new ArrayList<>();

            // process numbers in changed[] in ASC order
            Arrays.sort(changed);
            Map<Integer, Integer> counts = new HashMap<>();
            for (int x : changed) {
                // is x a doubled value?
                if (x % 2 == 0 && counts.containsKey(x / 2) && counts.get(x / 2) > 0) {
                    ans.add(x / 2);
                    counts.put(x / 2, counts.get(x / 2) - 1);
                } else {
                    // x is a smaller value, i.e. a value to be doubled
                    counts.put(x, counts.getOrDefault(x, 0) + 1);
                }
            }

            if (ans.size() * 2 != n) {
                return new int[0];
            }

            int[] arr = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                arr[i] = ans.get(i);
            }
            return arr;
        }
    }
}
