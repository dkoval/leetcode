package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3769/">Longest Consecutive Sequence</a>
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int x : nums) {
            numsSet.add(x);
        }

        int maxLength = 0;
        for (int x : numsSet) {
            if (!numsSet.contains(x - 1)) {
                // star new sequence
                int currLength = 1;
                int y = x + 1;
                while (numsSet.contains(y)) {
                    currLength++;
                    y++;
                }
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }
}
