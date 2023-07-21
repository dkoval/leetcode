package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/">Number of Longest Increasing Subsequence</a>
 * <p>
 * Given an integer array nums, return the number of longest increasing subsequences.
 * <p>
 * Notice that the sequence has to be strictly increasing.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 2000</li>
 *  <li>-106 <= nums[i] <= 10^6</li>
 * </ul>
 */
public interface NumberOfLongestIncreasingSubsequence {

    int findNumberOfLIS(int[] nums);

    // Time complexity: O(N^2)
    // Space complexity: O(N)
    class NumberOfLongestIncreasingSubsequenceRev1 implements NumberOfLongestIncreasingSubsequence {

        @Override
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;

            // lis[i] - the length of LIS starting at index i
            int[] lis = new int[n];
            // count[i] - number of LISs starting at index i
            int[] count = new int[n];

            int bestLength = 1;
            for (int i = n - 1; i >= 0; i--) {
                // nums[i] is a LIS of length 1
                lis[i] = 1;
                count[i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] < nums[j]) {
                        // extend count[j] subsequences starting at index j by prepending nums[i] to all of them
                        if (lis[i] < lis[j] + 1) {
                            lis[i] = lis[j] + 1;
                            count[i] = count[j];
                        } else if (lis[i] == lis[j] + 1) {
                            count[i] += count[j];
                        }
                    }
                }
                bestLength = Math.max(bestLength, lis[i]);
            }

            int total = 0;
            for (int i = 0; i < n; i++) {
                if (lis[i] == bestLength) {
                    total += count[i];
                }
            }
            return total;
        }
    }

    // Time complexity: O(N^2)
    // Space complexity: O(N)
    class NumberOfLongestIncreasingSubsequenceRev2 implements NumberOfLongestIncreasingSubsequence {

        @Override
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;

            // len[i] - the length of LIS ending at index i
            int[] len = new int[n];
            // count[i] - the number of LIS of length len[i] ending at index i
            int[] count = new int[n];

            int best = 0;
            for (int i = 0; i < n; i++) {
                len[i] = 1;
                count[i] = 1;
                // check if we can append nums[i] to any existing LIS to make it even longer
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        if (len[i] < len[j] + 1) {
                            len[i] = len[j] + 1;
                            count[i] = count[j];
                        } else if (len[i] == len[j] + 1) {
                            count[i] += count[j];
                        }
                    }
                }
                best = Math.max(best, len[i]);
            }

            int total = 0;
            for (int i = 0; i < n; i++) {
                if (len[i] == best) {
                    total += count[i];
                }
            }
            return total;
        }
    }
}
