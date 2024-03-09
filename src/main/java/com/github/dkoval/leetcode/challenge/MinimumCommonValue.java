package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-common-value/">Minimum Common Value</a>
 * <p>
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays.
 * If there is no common integer amongst nums1 and nums2, return -1.
 * <p>
 * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 105</li>
 *  <li>1 <= nums1[i], nums2[j] <= 109</li>
 *  <li>Both nums1 and nums2 are sorted in non-decreasing order</li>
 * </ul>
 */
public interface MinimumCommonValue {

    int getCommon(int[] nums1, int[] nums2);

    // O(min(N1, N2)) time | O(1) space
    class MinimumCommonValueRev1 implements MinimumCommonValue {

        @Override
        public int getCommon(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            int i1 = 0;
            int i2 = 0;
            while (i1 < n1 && i2 < n2) {
                if (nums1[i1] == nums2[i2]) {
                    return nums1[i1];
                }

                if (nums1[i1] < nums2[i2]) {
                    i1++;
                } else {
                    i2++;
                }
            }
            return -1;
        }
    }
}
