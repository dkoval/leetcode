package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays/">Intersection of Two Arrays</a>
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 1000</li>
 *  <li>0 <= nums1[i], nums2[i] <= 1000</li>
 * </ul>
 */
public interface IntersectionOfTwoArrays {

    int[] intersection(int[] nums1, int[] nums2);

    class IntersectionOfTwoArraysRev1 implements IntersectionOfTwoArrays {

        @Override
        public int[] intersection(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if (n2 > n1) {
                return intersection(nums2, nums1);
            }

            Set<Integer> uniq = new HashSet<>();
            for (int x : nums1) {
                uniq.add(x);
            }

            Arrays.sort(nums2);

            List<Integer> ans = new ArrayList<>();
            int i2 = 0;
            while (i2 < n2) {
                if (uniq.contains(nums2[i2])) {
                    ans.add(nums2[i2]);
                }

                // ignore duplicates
                i2++;
                while (i2 < n2 && nums2[i2] == nums2[i2 - 1]) {
                    i2++;
                }
            }
            return toArray(ans);
        }

        private int[] toArray(List<Integer> nums) {
            int[] ans = new int[nums.size()];
            int i = 0;
            for (int x : nums) {
                ans[i++] = x;
            }
            return ans;
        }
    }

    class IntersectionOfTwoArraysRev2 implements IntersectionOfTwoArrays {

        @Override
        public int[] intersection(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            List<Integer> ans = new ArrayList<>();
            int i1 = 0;
            int i2 = 0;
            while (i1 < n1 && i2 < n2) {
                // ignore duplicates in nums1[]
                while (i1 + 1 < n1 && nums1[i1] == nums1[i1 + 1]) {
                    i1++;
                }

                // ignore duplicates in nums2[]
                while (i2 + 1 < n2 && nums2[i2] == nums2[i2 + 1]) {
                    i2++;
                }

                if (nums1[i1] < nums2[i2]) {
                    i1++;
                } else if (nums2[i2] < nums1[i1])  {
                    i2++;
                } else {
                    ans.add(nums1[i1]);
                    i1++;
                    i2++;
                }
            }
            return toArray(ans);
        }

        private int[] toArray(List<Integer> nums) {
            int[] ans = new int[nums.size()];
            int i = 0;
            for (int x : nums) {
                ans[i++] = x;
            }
            return ans;
        }
    }
}
