package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/uncrossed-lines/">Uncrossed Lines</a>
 * <p>
 * You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.
 * <p>
 * We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
 * <ul>
 *  <li>nums1[i] == nums2[j], and</li>
 *  <li>the line we draw does not intersect any other connecting (non-horizontal) line.</li>
 *  </ul>
 * Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).
 * <p>
 * Return the maximum number of connecting lines we can draw in this way.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 500</li>
 *  <li>1 <= nums1[i], nums2[j] <= 2000</li>
 * </ul>
 */
public interface UncrossedLines {

    int maxUncrossedLines(int[] nums1, int[] nums2);

    class UncrossedLinesDPTopDown implements UncrossedLines {

        @Override
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            // DP: top-down
            Integer[][] dp = new Integer[n1][n2];
            return calculate(nums1, nums2, 0, 0, dp);
        }

        private int calculate(int[] nums1, int[] nums2, int idx1, int idx2, Integer[][] dp) {
            // base case
            if (idx1 >= nums1.length || idx2 >= nums2.length) {
                return 0;
            }

            // already solved?
            if (dp[idx1][idx2] != null) {
                return dp[idx1][idx2];
            }

            int best = 0;
            if (nums1[idx1] == nums2[idx2]) {
                best = 1 + calculate(nums1, nums2, idx1 + 1, idx2 + 1, dp);
            } else {
                // option #1: leave nums1[idx1] and try to find a match in nums2[idx2 : ]
                best = Math.max(best, calculate(nums1, nums2, idx1, idx2 + 1, dp));
                // option #2: leave nums2[idx2] and try to find a match in nums1[idx1 : ]
                best = Math.max(best, calculate(nums1, nums2, idx1 + 1, idx2, dp));
            }
            return dp[idx1][idx2] = best;
        }
    }
}
