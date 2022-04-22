package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.challenge.FindDuplicateNumber;
import org.jetbrains.annotations.NotNull;

public class FindDuplicateNumberUsingFloydAlgorithm implements FindDuplicateNumber {

    // O(N) time | O(1) extra space
    @Override
    public int findDuplicate(@NotNull int[] nums) {
        // The problem reduces to the problem of finding the starting node of the cycle in a linked list,
        // which can be solved with Floyd's algorithm.
        // Idea: to compose a linked list, interpret nums[i] as the index of next number of i.
        int fast = 0; // index in nums[]
        int slow = 0; // index in nums[]
        do {
            // move slow and fast indices 1 and 2 steps at a time correspondingly
            // until both indices eventually meet
            slow = nums[slow];       // index of the next number
            fast = nums[nums[fast]]; // index of the 2nd next number
        } while (nums[fast] != nums[slow]);

        fast = 0;
        while (nums[fast] != nums[slow]) {
            // now, move both slow and fast indices 1 step at a time
            slow = nums[slow];
            fast = nums[fast];
        }

        // both indices meet at the beginning of the cycle
        return nums[fast];
    }
}
