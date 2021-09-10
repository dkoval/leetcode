package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3970/">Arithmetic Slices II - Subsequence (Hard)</a>
 * <p>
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 * <p>
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 * <ul>
 *  <li>For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.</li>
 *  <li>For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.</li>
 * </ul>
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 * <p>
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The test cases are generated so that the answer fits in 32-bit integer.
 */
public class ArithmeticSlices2Subsequence {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int answer = 0;

        Map<Integer, Integer>[] diffCounts = new Map[n];
        for (int i = 0; i < n; i++) {
            diffCounts[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long longDiff = (long) nums[j] - nums[i];
                if (longDiff < Integer.MIN_VALUE || longDiff > Integer.MAX_VALUE) {
                    continue;
                }

                int diff = (int) longDiff;
                int count1 = diffCounts[j].getOrDefault(diff, 0);
                int count2 = diffCounts[i].getOrDefault(diff, 0);

                // append nums[i] to the existing `count1` arithmetic subsequences having the difference between
                // any two consecutive elements equal to `diff`
                answer += count1;
                diffCounts[i].put(diff, count1 + count2 + 1);
            }
        }
        return answer;
    }
}
