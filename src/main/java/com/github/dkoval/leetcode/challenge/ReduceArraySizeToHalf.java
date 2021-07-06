package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3804/">Reduce Array Size to The Half</a>
 * <p>
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
 * <p>
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 */
public class ReduceArraySizeToHalf {

    // O(NlogN) time | O(N) space
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Integer[] frequencies = frequencyMap.values().toArray(new Integer[0]);
        Arrays.sort(frequencies, Comparator.reverseOrder());
        int target = arr.length / 2;
        int numRemoved = 0;
        int minSetSize = 0;
        int i = 0;
        while (numRemoved < target) {
            numRemoved += frequencies[i++];
            minSetSize++;
        }
        return minSetSize;
    }
}
