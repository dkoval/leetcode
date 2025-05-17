package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">Sort Colors</a>
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= n <= 300</li>
 *  <li>nums[i] is either 0, 1, or 2.</li>
 * </ul>
 */
public interface SortColors {

    void sortColors(int[] nums);

    // O(N) time | O(1) space
    class SortColorsInTwoPasses implements SortColors {

        @Override
        public void sortColors(int[] nums) {
            int n = nums.length;

            // 1st pass: move all 0's to the start of the array
            int onesStartAt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    swap(nums, i, onesStartAt++);
                }
            }

            // 2nd pass: move all 2's to the end of the array
            int onesEndAt = n - 1;
            for (int i = n - 1; i >= onesStartAt; i--) {
                if (nums[i] == 2) {
                    swap(nums, i, onesEndAt--);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) {
                return;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    // O(N) time | O(1) space
    class SortColorsWithCountingSort implements SortColors {

        @Override
        public void sortColors(int[] nums) {
            // 1st pass: count number of 0's, 1's and 2's
            final var colors = new int[3];
            for (var x : nums) {
                colors[x]++;
            }

            // 2nd pass: override nums[] array
            var i = 0;
            for (var x = 0; x < 3; x++) {
                var count = colors[x];
                while (count-- > 0) {
                    nums[i++] = x;
                }
            }
        }
    }
}
