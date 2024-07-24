package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sort-the-jumbled-numbers/">Sort the Jumbled Numbers</a>
 * <p>
 * You are given a 0-indexed integer array mapping which represents the mapping rule of a shuffled decimal system.
 * mapping[i] = j means digit i should be mapped to digit j in this system.
 * <p>
 * The mapped value of an integer is the new integer obtained by replacing each occurrence of digit i in the integer
 * with mapping[i] for all 0 <= i <= 9.
 * <p>
 * You are also given another integer array nums. Return the array nums sorted in non-decreasing order based on
 * the mapped values of its elements.
 * <p>
 * Notes:
 * <ul>
 *  <li>Elements with the same mapped values should appear in the same relative order as in the input.</li>
 *  <li>The elements of nums should only be sorted based on their mapped values and not be replaced by them.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>mapping.length == 10</li>
 *  <li>0 <= mapping[i] <= 9</li>
 *  <li>All the values of mapping[i] are unique</li>
 *  <li>1 <= nums.length <= 3 * 10^4</li>
 *  <li>0 <= nums[i] < 10^9</li>
 * </ul>
 */
public interface SortJumbledNumbers {

    int[] sortJumbled(int[] mapping, int[] nums);

    class SortJumbledNumbersRev1 implements SortJumbledNumbers {

        @Override
        public int[] sortJumbled(int[] mapping, int[] nums) {
            int n = nums.length;

            Map<Integer, Integer> mappedNums = new HashMap<>();
            for (int x : nums) {
                mappedNums.put(x, mapNum(x, mapping));
            }

            Integer[] copy = new Integer[n];
            for (int i = 0; i < n; i++) {
                copy[i] = nums[i];
            }

            Arrays.sort(copy, Comparator.comparingInt(mappedNums::get));

            for (int i = 0; i < n; i++) {
                nums[i] = copy[i];
            }
            return nums;
        }

        private int mapNum(int x, int[] mapping) {
            if (x == 0) {
                return mapping[0];
            }

            int ans = 0;
            int shift = 1;
            while (x != 0) {
                int digit = x % 10;
                x /= 10;
                ans += mapping[digit] * shift;
                shift *= 10;
            }
            return ans;
        }
    }
}
