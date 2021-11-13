package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.challenge.MajorityElement;
import org.jetbrains.annotations.NotNull;

public class MajorityElementDivideAndConquer implements MajorityElement {

    @Override
    public int majorityElement(@NotNull int[] nums) {
        int n = nums.length;
        return majorityElement(nums, 0, n - 1);
    }

    private int majorityElement(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;
        int leftMajor = majorityElement(nums, start, mid);
        int rightMajor = majorityElement(nums, mid + 1, end);

        // both halves agreed on the majority element
        if (leftMajor == rightMajor) {
            return leftMajor;
        }

        int leftCount = count(nums, leftMajor, start, end);
        int rightCount = count(nums, rightMajor, start, end);
        return (leftCount > rightCount) ? leftMajor : rightMajor;
    }

    private int count(int[] nums, int target, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}
