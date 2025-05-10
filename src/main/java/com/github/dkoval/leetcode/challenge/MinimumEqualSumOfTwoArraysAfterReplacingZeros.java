package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/">Minimum Equal Sum of Two Arrays After Replacing Zeros</a>
 * <p>
 * You are given two arrays nums1 and nums2 consisting of positive integers.
 * <p>
 * You have to replace all the 0's in both arrays with strictly positive integers such that the sum of elements of both arrays becomes equal.
 * <p>
 * Return the minimum equal sum you can obtain, or -1 if it is impossible.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 10^5</li>
 *  <li>0 <= nums1[i], nums2[i] <= 10^6</li>
 * </ul>
 */
public interface MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    long minSum(int[] nums1, int[] nums2);

    class MinimumEqualSumOfTwoArraysAfterReplacingZerosRev1 implements MinimumEqualSumOfTwoArraysAfterReplacingZeros {

        @Override
        public long minSum(int[] nums1, int[] nums2) {
            final var interval1 = interval(nums1);
            final var interval2 = interval(nums2);

            // no overlap?
            if (interval1.min > interval2.max || interval1.max < interval2.min) {
                return -1;
            }

            // 1st point at which both intervals intersect
            return Math.max(interval1.min, interval2.min);
        }

        private Interval interval(int[] nums) {
            var sum = 0L;
            var numZeros = 0;
            for (var x : nums) {
                sum += x;
                if (x == 0) {
                    numZeros++;
                }
            }

            // set all 0's to 1
            final var min = sum + numZeros;
            final var max = (numZeros > 0) ? Long.MAX_VALUE : sum;
            return new Interval(min, max);
        }

        private record Interval(long min, long max) {
        }
    }
}
