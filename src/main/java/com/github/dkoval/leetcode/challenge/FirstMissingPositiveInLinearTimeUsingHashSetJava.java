package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositiveInLinearTimeUsingHashSetJava implements FirstMissingPositive {

    @Override
    public int firstMissingPositive(@NotNull int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                numsSet.add(num);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!numsSet.contains(i)) return i;
        }
        return nums.length + 1;
    }
}
