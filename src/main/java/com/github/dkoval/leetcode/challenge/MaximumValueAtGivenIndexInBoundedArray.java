package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/">Maximum Value at a Given Index in a Bounded Array</a>
 * <p>
 * You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
 * <ul>
 *  <li>nums.length == n</li>
 *  <li>nums[i] is a positive integer where 0 <= i < n.</li>
 *  <li>abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.</li>
 *  <li>The sum of all the elements of nums does not exceed maxSum.</li>
 *  <li>nums[index] is maximized.</li>
 * </ul>
 * Return nums[index] of the constructed array.
 * <p>
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= maxSum <= 10^9</li>
 *  <li>0 <= index < n</li>
 * </ul>
 */
public interface MaximumValueAtGivenIndexInBoundedArray {

    int maxValue(int n, int index, int maxSum);

    class MaximumValueAtGivenIndexInBoundedArrayRev1 implements MaximumValueAtGivenIndexInBoundedArray {

        @Override
        public int maxValue(int n, int index, int maxSum) {
            // idea: binary search
            // nums = [increasing] peak [decreasing]
            // isGood(peak, n, index, maxSum)
            // TT...TFF...F
            //      ^ answer (upper boundary)
            int left = 1;
            int right = maxSum;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (isGood(mid, n, index, maxSum)) {
                    // mid might be the answer;
                    // check if there is a better alternative to the right of it
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private boolean isGood(int x, int n, int index, int maxSum) {
            long sumBefore = sum(x - 1, index);
            long sumAfter = sum(x - 1, n - index - 1);
            return (sumBefore + x + sumAfter) <= maxSum;
        }

        private long sum(int upper, int count) {
            // case #1 - not enough numbers: count >= upper (need to prepend 1's)
            // 1 + 1 + 1 + ... + 1 | 1 + 2 + 3 + ... + upper
            // <- (count - upper) ->
            // <------------------- count ------------------>
            // sum = sum[1 : upper] + (count - upper)
            // = upper * (upper + 1) / 2 + (count - upper)
            //
            // case #2 - enough numbers: count < upper
            // sum = (upper - count + 1) + (upper - count + 2) + ... + upper
            // = sum[1 : upper] - sum[1 : upper - count]
            // = upper * (upper + 1) / 2 - (upper - count) * (upper - count + 1) / 2
            long sum = (long) upper * (upper + 1) / 2;
            long delta = Math.abs(count - upper);
            sum += (count >= upper) ? delta : -(delta * (delta + 1) / 2);
            return sum;
        }
    }
}
