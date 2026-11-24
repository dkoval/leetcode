package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray-with-equal-products/">Maximum Subarray With Equal Products</a>
 * <p>
 * You are given an array of positive integers nums.
 * <p>
 * An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), where:
 * <p>
 * prod(arr) is the product of all elements of arr.
 * <p>
 * gcd(arr) is the GCD of all elements of arr.
 * <p>
 * lcm(arr) is the LCM of all elements of arr.
 * <p>
 * Return the length of the longest product equivalent subarray of nums.
 */
public interface MaximumSubarrayWithEqualProducts {

    int maxLength(int[] nums);

    class MaximumSubarrayWithEqualProductsRev1 implements MaximumSubarrayWithEqualProducts {

        @Override
        public int maxLength(int[] nums) {
            final var n = nums.length;

            // brute force
            var best = 0;
            for (var i = 0; i < n; i++) {
                var prod = nums[i];
                var lcm = nums[i];
                var gcd = nums[i];
                for (var j = i + 1; j < n; j++) {
                    prod *= nums[j];
                    gcd = gcd(gcd, nums[j]);
                    lcm = lcm(lcm, nums[j]);

                    final var diff = prod - lcm * gcd;
                    if (diff > 0) {
                        break;
                    }

                    if (diff == 0) {
                        best = Math.max(best, j - i + 1);
                    }
                }
            }
            return best;
        }

        private int lcm(int a, int b) {
            return (a * b) / gcd(a, b);
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }
}
