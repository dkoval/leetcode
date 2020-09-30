package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class FirstMissingPositiveBruteForceJava implements FirstMissingPositive {

    @Override
    public int firstMissingPositive(@NotNull int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return nums.length + 1;
    }
}
