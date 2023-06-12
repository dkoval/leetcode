package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/summary-ranges/">Summary Ranges</a>
 * <p>
 * You are given a sorted unique integer array nums.
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x
 * such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <ul>
 *  <li>"a->b" if a != b</li>
 *  <li>"a" if a == b</li>
 * </ul>
 * Constraints:
 * <ul>
 *  <li>0 <= nums.length <= 20</li>
 *  <li>-2^31 <= nums[i] <= 2^31 - 1</li>
 *  <li>All the values of nums are unique.</li>
 *  <li>nums is sorted in ascending order.</li>
 * </ul>
 */
public interface SummaryRanges {

    List<String> summaryRanges(int[] nums);

    // O(N) time | O(N) space, O(1) extra space
    class SummaryRangesRev1 implements SummaryRanges {

        @Override
        public List<String> summaryRanges(int[] nums) {
            int n = nums.length;

            if (n == 0) {
                return Collections.emptyList();
            }

            List<String> ans = new ArrayList<>();
            int start = 0;
            for (int end = 1; end < n; end++) {
                if (nums[end - 1] + 1 != nums[end]) {
                    ans.add(format(nums[start], nums[end - 1]));
                    start = end;
                }
            }

            ans.add(format(nums[start], nums[n - 1]));
            return ans;
        }

        private String format(int a, int b) {
            return (a == b) ? Integer.toString(a) : a + "->" + b;
        }
    }

    private String formatRange(int[] nums, int start, int end) {
        int a = nums[start], b = nums[end];
        return (a == b) ? String.valueOf(a) : a + "->" + b;
    }
}
