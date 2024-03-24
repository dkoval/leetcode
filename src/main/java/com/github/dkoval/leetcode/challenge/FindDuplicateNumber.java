package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number">Find the Duplicate Number</a>
 * <p>
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>nums.length == n + 1</li>
 *  <li>1 <= nums(i) <= n</li>
 *  <li>All the integers in nums appear only once except for precisely one integer which appears two or more times</li>
 * </ul>
 */
public interface FindDuplicateNumber {

    int findDuplicate(int[] nums);

    // O(N) time | O(1) extra space
    class FindDuplicateNumberUsingFloydAlgorithm implements FindDuplicateNumber {

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
}
