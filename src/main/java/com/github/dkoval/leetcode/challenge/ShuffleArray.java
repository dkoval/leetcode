package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/shuffle-the-array/">Shuffle the Array</a>
 * <p>
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * <p>
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 500</li>
 *  <li>nums.length == 2n</li>
 *  <li>1 <= nums[i] <= 10^3</li>
 * </ul>
 */
public interface ShuffleArray {

    int[] shuffle(int[] nums, int n);

    // O(N) time | O(N) extra space
    class ShuffleArrayNaive implements ShuffleArray {

        @Override
        public int[] shuffle(int[] nums, int n) {
            int[] ans = new int[2 * n];
            int j = 0;
            for (int i = 0; i < n; i++) {
                ans[j] = nums[i];
                ans[j + 1] = nums[i + n];
                j += 2;
            }
            return ans;
        }
    }

    // Resource: https://www.youtube.com/watch?v=IvIKD_EU8BY
    class ShuffleArrayInplace implements ShuffleArray {

        // O(N) time | O(1) extra space
        @Override
        public int[] shuffle(int[] nums, int n) {
            // 1 <= nums[i] <= 10^3
            // It takes <= 10 bits to represent a nums[i], therefore
            // we can compress (xi, yi) into a 32-bit integer
            for (int i = 0; i < n; i++) {
                // make space for yi
                nums[i] = nums[i] << 10;
                // append yi
                nums[i] = nums[i] | nums[i + n];
            }

            int j = 2 * n - 1;
            for (int i = n - 1; i >= 0; i--) {
                // extract yi - bitwise AND with (2^10 - 1) mask extracts the first 10 LSBs
                int y = nums[i] & ((1 << 10) - 1);
                // extract xi
                int x = nums[i] >> 10;

                // update ans
                nums[j] = y;
                nums[j - 1] = x;
                j -= 2;
            }
            return nums;
        }
    }
}
