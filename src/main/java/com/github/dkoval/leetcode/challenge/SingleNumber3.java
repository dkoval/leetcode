package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/single-number-iii/">Single Number III</a>
 * <p>
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once. You can return the answer in any order.
 * <p>
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 3 * 10^4</li>
 *  <li>-2^31 <= nums[i] <= 2^31 - 1</li>
 *  <li>Each integer in nums will appear twice, only two integers will appear once.</li>
 * </ul>
 */
public interface SingleNumber3 {

    int[] singleNumber(int[] nums);

    class SingleNumber3Rev2 implements SingleNumber3 {

        @Override
        public int[] singleNumber(int[] nums) {
            // x ^ x = 0
            // x ^ 0 = x
            int ab = 0;
            for (int x : nums) {
                ab ^= x;
            }

            // Now, we somehow need to distill a and b from ab.
            // If the i-th bit of ab is set to 1, then this bit is set to 1 in either a or b exclusively:
            // 1 ^ 0 = 1
            // 0 ^ 1 = 1
            // 1 ^ 1 = 0
            // 0 ^ 0 = 0
            //
            // We'll use this fact to mark a and b in nums[].
            // Marker can be any bit set to 1 in ab (i.e. 00..10..0).
            //
            // For any number x in nums[]:
            // x ^ marker = marker, or x ^ marker = 0
            int marker = lsb(ab);

            // xor elements of nums[] once again, but this time, split them into 2 groups based on (x ^ marker)
            int[] ans = new int[2];
            for (int x : nums) {
                int group = (x & marker) == 0 ? 0 : 1;
                ans[group] ^= x;
            }
            return ans;
        }

        private int lsb(int x) {
            int i = 0;
            while ((x & 1) != 1) {
                x >>= 1;
                i++;
            }
            return 1 << i;
        }
    }
}
