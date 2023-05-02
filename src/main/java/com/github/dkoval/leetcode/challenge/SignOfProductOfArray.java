package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sign-of-the-product-of-an-array/">Sign of the Product of an Array</a>
 * <p>
 * There is a function signFunc(x) that returns:
 * <p>
 * 1 if x is positive.
 * -1 if x is negative.
 * 0 if x is equal to 0.
 * You are given an integer array nums. Let product be the product of all values in the array nums.
 * <p>
 * Return signFunc(product).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>-100 <= nums[i] <= 100</li>
 * </ul>
 */
public interface SignOfProductOfArray {

    int arraySign(int[] nums);

    class SignOfProductOfArrayRev1 implements SignOfProductOfArray {

        @Override
        public int arraySign(int[] nums) {
            int negatives = 0;
            for (int x : nums) {
                if (x == 0) {
                    return 0;
                }
                negatives += (x < 0) ? 1 : 0;
            }
            return (negatives % 2 == 0) ? 1 : -1;
        }
    }
}
