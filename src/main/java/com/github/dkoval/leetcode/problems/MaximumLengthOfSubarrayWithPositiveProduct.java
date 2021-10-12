package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/">Maximum Length of Subarray With Positive Product</a>
 * <p>
 * Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
 * <p>
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
 * <p>
 * Return the maximum length of a subarray with positive product.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {

    private static class SubarrInfo {
        final int start;
        final int end;
        final int negCount;

        SubarrInfo(int start, int end, int negCount) {
            this.start = start;
            this.end = end;
            this.negCount = negCount;
        }
    }

    public int getMaxLen(int[] nums) {
        int maxLen = 0;
        List<SubarrInfo> subarrs = split(nums);
        for (SubarrInfo subarr : subarrs) {
            int currLen = 0;
            if (subarr.negCount % 2 == 0) {
                currLen = subarr.end - subarr.start + 1;
            } else {
                // option #1: remove the prefix till the first negative element in this subarray
                currLen = Math.max(currLen, maxSuffixLen(nums, subarr.start, subarr.end));
                // option #2: remove the suffix starting from the last negative element in this subarray
                currLen = Math.max(currLen, maxPrefixLen(nums, subarr.start, subarr.end));
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

    private List<SubarrInfo> split(int[] nums) {
        // Split the whole array into subarrays by 0s since a subarray with positive product cannot contain any 0s
        int n = nums.length;
        int end = 0;
        List<SubarrInfo> result = new ArrayList<>();
        while (end < n) {
            int start = end;
            int product = 1;
            int negCount = 0;
            while (end < n && nums[end] != 0) {
                product *= nums[end];
                if (nums[end] < 0) {
                    negCount++;
                }
                end++;
            }
            if (start != end) {
                result.add(new SubarrInfo(start, end - 1, negCount));
            }
            // skip over 0
            end++;
        }
        return result;
    }

    private int maxSuffixLen(int[] nums, int start, int end) {
        int l = start;
        while (l <= end) {
            if (nums[l] < 0) {
                break;
            }
            l++;
        }
        return (l < end) ? end - l : 0;
    }

    private int maxPrefixLen(int[] nums, int start, int end) {
        int r = end;
        while (r >= start) {
            if (nums[r] < 0) {
                break;
            }
            r--;
        }
        return (r > start) ? r - start : 0;
    }
}
