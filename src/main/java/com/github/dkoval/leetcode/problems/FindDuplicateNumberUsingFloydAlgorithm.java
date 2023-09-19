package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.challenge.FindDuplicateNumber;
import org.jetbrains.annotations.NotNull;

public class FindDuplicateNumberUsingFloydAlgorithm implements FindDuplicateNumber {

    // O(N) time | O(1) extra space
    @Override
    public int findDuplicate(@NotNull int[] nums) {
        // Represent nums[] as a singly linked list, where
        // node.val = index
        // node.next = nums[index]
        //
        // Example: nums = [1, 3, 4, 2, 2]
        //        indices = 0, 1, 2, 3, 4
        //
        // 0 -> 1 -> 3 -> 2 -> 4
        //                ^    |
        //                |____|
        //
        // The repeated number is the start of the cycle.
        //
        // The problem reduces to the problem of finding the starting node of the cycle in a linked list,
        // which can be solved with Floyd's algorithm using "slow" and "fast" pointers.
        int slow = nums[0];
        int fast = nums[0];

        // Move "slow" and "fast" pointers 1 and 2 steps at a time respectively until they eventually meet.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Now, move "slow" pointer at the beginning of the list, then start moving both "slow" and "fast" pointers
        // 1 step at a time until they meet. The meeting point is the start of the cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
