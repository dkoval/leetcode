package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3877/">Array of Doubled Pairs</a>
 * <p>
 * Given an array of integers arr of even length, return true if and only if it is possible to reorder it such
 * that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2.
 */
public class ArrayOfDoubledPairs {

    // O(N * logN) time | O(N) space
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;

        // count occurrences of numbers in arr[]
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : arr) {
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }

        // sort numbers of arr[] by their absolute values in asc order to handle negative integers
        Integer[] sorted = Arrays.stream(arr)
                .boxed() // int -> Integer
                .sorted(Comparator.comparingInt(Math::abs))
                .toArray(Integer[]::new);

        for (Integer x : sorted) {
            if (counts.get(x) == 0) {
                // already formed (x, 2 * x) pair
                continue;
            }

            if (counts.getOrDefault(2 * x, 0) == 0) {
                // 2 * x  number is not in arr[], or is not available to form (x, 2 * x) pair
                return false;
            }

            // (x, 2 * x) pair is formed, therefore decrement occurrences of numbers
            counts.put(x, counts.get(x) - 1);
            counts.put(2 * x, counts.get(2 * x) - 1);
        }
        return true;
    }
}
