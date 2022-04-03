package com.github.dkoval.leetcode.interview.array;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/59/array-and-strings/3050/">Next Permutation</a>
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * The replacement must be in place and use only constant extra memory
 */
public class NextPermutation {

    // Resource: https://www.youtube.com/watch?v=quAS1iydq7U
    // Time complexity: O(N)
    // Space complexity: O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // Find the longest decreasing suffix of nums[]; nums[k] denotes the start of the suffix.
        // We can't get the next permutation by modifying this suffix, since it is already the maximum it can be.
        int k = n - 1;
        while (k > 0 && nums[k - 1] >= nums[k]) {
            k--;
        }

        if (k == 0) {
            // nums[] is sorted in desc order, therefore reverse(nums) will make the array sorted in asc order
            reverse(nums, 0, n - 1);
            return;
        }

        // Swap nums[k - 1] with the first nums[i] > nums[k - 1] in nums[k:] suffix
        for (int i = n - 1; i >= k; i--) {
            if (nums[i] > nums[k - 1]) {
                swap(nums, k - 1, i);
                break;
            }
        }

        // At this stage, new prefix is the smallest possible for all permutations that are
        // greater than the initial one. But the new suffix may not be the smallest. We can obtain
        // the smallest suffix by sorting it in asc order. Since the new suffix is already
        // sorted in desc order, we can just reverse it to make it sorted in asc order.
        reverse(nums, k, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
