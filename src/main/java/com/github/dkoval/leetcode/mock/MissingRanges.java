package com.github.dkoval.leetcode.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/missing-ranges/">Missing Ranges</a>
 * <p>
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums,
 * where all elements are in the inclusive range.
 * <p>
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 * <p>
 * Return the smallest sorted list of ranges that cover every missing number exactly.
 * That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            return Collections.singletonList(formatRange(lower, upper));
        }
        List<String> result = new ArrayList<>();
        if (nums[0] > lower) {
            result.add(formatRange(lower, nums[0] - 1));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                result.add(formatRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            result.add(formatRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    private String formatRange(int lower, int upper) {
        return (lower == upper) ? String.valueOf(lower) : lower + "->" + upper;
    }
}
