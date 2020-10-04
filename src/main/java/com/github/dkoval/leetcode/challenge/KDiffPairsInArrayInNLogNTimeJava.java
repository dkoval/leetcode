package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class KDiffPairsInArrayInNLogNTimeJava implements KDiffPairsInArray {

    @Override
    public int findPairs(@NotNull int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        Integer prev = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (prev != null && prev == nums[i]) continue;
            int index = Arrays.binarySearch(nums, i + 1, nums.length, nums[i] + k);
            if (index >= 0) count++;
            prev = nums[i];
        }
        return count;
    }
}
