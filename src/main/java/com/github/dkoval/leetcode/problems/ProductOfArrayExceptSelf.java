package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 * <p>
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^5</li>
 *  <li>-30 <= nums[i] <= 30</li>
 *  <li>The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer</li>
 * </ul>
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public interface ProductOfArrayExceptSelf {

    int[] productExceptSelf(int[] nums);

    // O(N) time | O(N) extra space
    class ProductOfArrayExceptSelfUsingExtraSpace implements ProductOfArrayExceptSelf {

        @Override
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] prefixProduct = new int[n];
            int[] suffixProduct = new int[n];

            for (int i = 0; i < n; i++) {
                prefixProduct[i] = nums[i] * (i > 0 ? prefixProduct[i - 1] : 1);
                suffixProduct[n - i - 1] = nums[n - i - 1] * (i > 0 ? suffixProduct[n - i] : 1);
            }

            int[] ans = new int[n];
            ans[0] = suffixProduct[1];
            ans[n - 1] = prefixProduct[n - 2];
            for (int i = 1; i < n - 1; i++) {
                ans[i] = prefixProduct[i - 1] * suffixProduct[i + 1];
            }
            return ans;
        }
    }

    // O(N) time | O(1) extra space
    class ProductOfArrayExceptSelfWithoutExtraSpace implements ProductOfArrayExceptSelf {

        @Override
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];

            // 1st pass: prefix[i] = nums[0] * ... * nums[i - 1], prefix[0] = 1
            ans[0] = 1;
            for (int i = 1; i < n; i++) {
                ans[i] = nums[i - 1] * ans[i - 1];
            }

            // 2nd pass: suffix[i] = nums[n - 1] * ... * nums[i + 1], suffix[n - 1] = 1
            // Also note that ans[i] = prefix[i] * suffix[i] yields the product of all numbers of nums[] except nums[i]
            int suffix = 1;
            for (int i = n - 1; i >= 0; i--) {
                // at ths stage, ans[i] stores prefix = nums[0] * ... * nums[i - 1],
                // therefore ans[i] * suffix gives the desired product at index i
                ans[i] *= suffix;
                suffix *= nums[i];
            }
            return ans;
        }
    }
}
