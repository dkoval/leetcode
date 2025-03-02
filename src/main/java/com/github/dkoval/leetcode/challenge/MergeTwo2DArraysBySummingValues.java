package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/">Merge Two 2D Arrays by Summing Values</a>
 * <p>
 * You are given two 2D integer arrays nums1 and nums2.
 * <ul>
 *  <li>nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.</li>
 *  <li>nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.</li>
 * </ul>
 * Each array contains unique ids and is sorted in ascending order by id.
 * <p>
 * Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
 * <ul>
 *  <li>Only ids that appear in at least one of the two arrays should be included in the resulting array.</li>
 *  <li>Each id should be included only once and its value should be the sum of the values of this id in the two arrays.
 *  If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
 *  </li>
 * </ul>
 * Return the resulting array. The returned array must be sorted in ascending order by id.
 */
public interface MergeTwo2DArraysBySummingValues {

    int[][] mergeArrays(int[][] nums1, int[][] nums2);

    class MergeTwo2DArraysBySummingValuesRev1 implements MergeTwo2DArraysBySummingValues {

        @Override
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            final var n1 = nums1.length;
            final var n2 = nums2.length;

            final var ans = new ArrayList<int[]>();
            var i1 = 0;
            var i2 = 0;
            while (i1 < n1 && i2 < n2) {
                if (nums1[i1][0] < nums2[i2][0]) {
                    ans.add(nums1[i1]);
                    i1++;
                } else if (nums2[i2][0] < nums1[i1][0]) {
                    ans.add(nums2[i2]);
                    i2++;
                } else {
                    ans.add(new int[]{nums1[i1][0], nums1[i1][1] + nums2[i2][1]});
                    i1++;
                    i2++;
                }
            }

            while (i1 < n1) {
                ans.add(nums1[i1]);
                i1++;
            }

            while (i2 < n2) {
                ans.add(nums2[i2]);
                i2++;
            }

            return ans.toArray(int[][]::new);
        }
    }
}
