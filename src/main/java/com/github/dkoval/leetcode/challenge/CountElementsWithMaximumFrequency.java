package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/count-elements-with-maximum-frequency/">Count Elements With Maximum Frequency</a>
 * <p>
 * You are given an array nums consisting of positive integers.
 * <p>
 * Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
 * <p>
 * The frequency of an element is the number of occurrences of that element in the array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface CountElementsWithMaximumFrequency {

    int maxFrequencyElements(int[] nums);

    class CountElementsWithMaximumFrequencyRev1 implements CountElementsWithMaximumFrequency {

        @Override
        public int maxFrequencyElements(int[] nums) {
            int n = nums.length;

            Map<Integer, Integer> freqs = new HashMap<>();
            for (int x : nums) {
                freqs.put(x, freqs.getOrDefault(x, 0) + 1);
            }

            if (freqs.size() == n) {
                return n;
            }

            int best = 0;
            int count = 0;
            for (int freq : freqs.values()) {
                if (freq > best) {
                    best = freq;
                    count = freq;
                } else if (freq == best) {
                    count += freq;
                }
            }
            return count;
        }
    }

    class CountElementsWithMaximumFrequencyRev2 implements CountElementsWithMaximumFrequency {

        @Override
        public int maxFrequencyElements(int[] nums) {
            int n = nums.length;

            int maxFreq = 0;
            int count = 0;
            Map<Integer, Integer> freqs = new HashMap<>();
            for (int x : nums) {
                int freq = freqs.getOrDefault(x, 0) + 1;
                freqs.put(x, freq);
                if (freq > maxFreq) {
                    maxFreq = freq;
                    count = 1;
                } else if (freq == maxFreq) {
                    count++;
                }
            }
            return maxFreq * count;
        }
    }
}
