package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Constraints:
 * <ul>
 *  <li>nums1.length == m</li>
 *  <li>nums2.length == n</li>
 *  <li>0 <= m <= 1000</li>
 *  <li>0 <= n <= 1000</li>
 *  <li>1 <= m + n <= 2000</li>
 *  <li>-10^6 <= nums1[i], nums2[i] <= 10^6</li>
 * </ul>
 */
public interface MedianOfTwoSortedArrays {

    double findMedianSortedArrays(int[] nums1, int[] nums2);

    // O(log(min(N1, N2)) time | O(1) space
    class MedianOfTwoSortedArraysRev1 implements MedianOfTwoSortedArrays {

        // Resource: https://youtu.be/MLUxShbDQLg?si=gTn92MR9Vj-EFGV2
        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // assume nums1 is smaller
            if (nums1.length > nums2.length) {
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }

            int n1 = nums1.length;
            int n2 = nums2.length;

            // the length of the entire merged array
            int l = n1 + n2;
            int h = l / 2;

            // split the entire merged array into 2 parts:
            // [...] | [...]
            //       ^ median
            // - left part comes before the median
            // - right part comes after the median
            //
            // binary search the valid split in the smaller array
            int left = -1; // left part can be empty
            int right = n1 - 1;
            while (left <= right) {
                // represent the index of the last elements in the left part of nums1 and nums2 arrays respectively
                int mid1 = left + (right - left) / 2;
                int mid2 = h - mid1 - 2;

                int lastLeft1 = (mid1 >= 0) ? nums1[mid1] : Integer.MIN_VALUE;
                int firstRight1 = (mid1 + 1 < n1) ? nums1[mid1 + 1] : Integer.MAX_VALUE;

                int lastLeft2 = (mid2 >= 0) ? nums2[mid2] : Integer.MIN_VALUE;
                int firstRight2 = (mid2 + 1 < n2) ? nums2[mid2 + 1] : Integer.MAX_VALUE;

                // is this a valid split (there always be the one)?
                if (lastLeft1 <= firstRight2 && lastLeft2 <= firstRight1) {
                    // handle odd / even length of the entire merged array
                    return (l % 2 != 0)
                            ? Math.min(firstRight1, firstRight2)
                            : (double) (Math.max(lastLeft1, lastLeft2) + Math.min(firstRight1, firstRight2)) / 2;
                }

                // no luck, keep on searching
                if (lastLeft1 > firstRight2) {
                    // shrink the split
                    right = mid1 - 1;
                } else {
                    // expand the split
                    left = mid1 + 1;
                }
            }
            throw new IllegalStateException("Too sad :(");
        }
    }
}
