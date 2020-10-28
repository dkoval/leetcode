package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3510/">Summary Ranges</a>
 * <p>
 * You are given a sorted unique integer array nums.
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x
 * such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) < 2) {
                end = i;
            } else {
                result.add(formatRange(nums, start, end));
                start = end = i;
            }
        }
        result.add(formatRange(nums, start, end));
        return result;
    }

    private String formatRange(int[] nums, int start, int end) {
        int a = nums[start], b = nums[end];
        return (a == b) ? String.valueOf(a) : a + "->" + b;
    }
}
