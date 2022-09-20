package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-repeated-subarray/">Maximum Length of Repeated Subarray</a>
 * <p>
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 1000</li>
 *  <li>0 <= nums1[i], nums2[i] <= 100</li>
 * </ul>
 */
public interface MaximumLengthOfRepeatedSubarray {

    int findLength(int[] nums1, int[] nums2);

    class MaximumLengthOfRepeatedSubarrayDPBottomUp implements MaximumLengthOfRepeatedSubarray {

        // O(N1 * N2) time | O(N1 * N2) space
        public int findLength(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            // dp[i][j] the maximum length of the longest common subarray of
            // nums1[0 : i - 1] and nums2[0 : j - 1] ending with nums1[i] and nums2[j]
            int best = 0;
            int[][] dp = new int[n1 + 1][n2 + 1];
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        best = Math.max(best, dp[i][j]);
                    }
                }
            }
            return best;
        }
    }

    class MaximumLengthOfRepeatedSubarrayWithOffset implements MaximumLengthOfRepeatedSubarray {

        // O(N1 * N2) time | O(1) space
        @Override
        public int findLength(int[] nums1, int[] nums2) {
            return Math.max(doFindLength(nums1, nums2), doFindLength(nums2, nums1));
        }

        private int doFindLength(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            int maxLength = 0;
            for (int offset = 0; offset < n2; offset++) {
                int currLength = 0;
                for (int i = 0; i < n1; i++) {
                    if (i + offset >= n2) {
                        break;
                    }

                    if (nums1[i] == nums2[i + offset]) {
                        currLength += 1;
                        maxLength = Math.max(maxLength, currLength);
                    } else {
                        currLength = 0;
                    }
                }
            }
            return maxLength;
        }
    }
}
