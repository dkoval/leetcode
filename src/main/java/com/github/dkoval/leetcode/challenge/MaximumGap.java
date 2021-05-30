package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/602/week-5-may-29th-may-31st/3761/">Maximum Gap</a>
 * <p>
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
 * <p>
 * You must write an algorithm that runs in linear time and uses linear extra space.
 */
public class MaximumGap {

    private static class MinMax {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        int totalNumbers = maxNum - minNum + 1;
        if (totalNumbers == 1) {
            return 0;
        }

        MinMax[] buckets = new MinMax[n];
        int numsPerBucket = totalNumbers / n + (totalNumbers % n == 0 ? 0 : 1);

        for (int num : nums) {
            int idx = (num - minNum) / numsPerBucket;
            if (buckets[idx] == null) {
                buckets[idx] = new MinMax();
            }
            buckets[idx].min = Math.min(buckets[idx].min, num);
            buckets[idx].max = Math.max(buckets[idx].max, num);
        }

        int maxDiff = 0;
        MinMax prevBucket = buckets[0];
        for (int i = 1; i < n; i++) {
            MinMax currBucket = buckets[i];
            if (currBucket == null) {
                continue;
            }
            if (prevBucket.max != Integer.MIN_VALUE && currBucket.min != Integer.MAX_VALUE) {
                maxDiff = Math.max(maxDiff, currBucket.min - prevBucket.max);
            }
            prevBucket = currBucket;
        }
        return maxDiff;
    }
}
