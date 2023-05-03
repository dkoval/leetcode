package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">Find the Difference of Two Arrays</a>
 * <p>
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * <ul>
 *  <li>answer[0] is a list of all distinct integers in nums1 which are not present in nums2.</li>
 *  <li>answer[1] is a list of all distinct integers in nums2 which are not present in nums1.</li>
 * </ul>
 * Note that the integers in the lists may be returned in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 1000</li>
 *  <li>-1000 <= nums1[i], nums2[i] <= 1000</li>
 * </ul>
 */
public interface FindDifferenceOfTwoArrays {

    List<List<Integer>> findDifference(int[] nums1, int[] nums2);

    // O(N1 + N2) time | O(N1 + N2) space
    class FindDifferenceOfTwoArraysRev1 implements FindDifferenceOfTwoArrays {

        @Override
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> set1 = setOf(nums1);
            Set<Integer> set2 = setOf(nums2);
            return Arrays.asList(distinct(set1, set2), distinct(set2, set1));
        }

        private Set<Integer> setOf(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int x : nums) {
                set.add(x);
            }
            return set;
        }

        private List<Integer> distinct(Set<Integer> nums1, Set<Integer> nums2) {
            List<Integer> distinct = new ArrayList<>();
            for (int x : nums1) {
                if (!nums2.contains(x)) {
                    distinct.add(x);
                }
            }
            return distinct;
        }
    }
}
