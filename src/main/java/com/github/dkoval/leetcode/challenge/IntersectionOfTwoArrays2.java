package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3978/">Intersection of Two Arrays II</a>
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 1000</li>
 *  <li>0 <= nums1[i], nums2[i] <= 1000</li>
 * </ul>
 */
public interface IntersectionOfTwoArrays2 {

    int[] intersect(int[] nums1, int[] nums2);

    // O(max(N1, N2)) time | O(max(N1, N2)) extra space
    class IntersectionOfTwoArrays2UsingMaps implements IntersectionOfTwoArrays2 {

        @Override
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> counts1 = counts(nums1.length < nums2.length ? nums1 : nums2);
            Map<Integer, Integer> counts2 = counts(nums2.length > nums1.length ? nums2 : nums1);

            List<Integer> result = new ArrayList<>();
            for (int x : counts1.keySet()) {
                if (counts2.containsKey(x)) {
                    int times = Math.min(counts1.get(x), counts2.get(x));
                    while (times-- > 0) {
                        result.add(x);
                    }
                }
            }
            return toPrimitiveArray(result);
        }

        private Map<Integer, Integer> counts(int[] nums) {
            Map<Integer, Integer> counts = new LinkedHashMap<>();
            for (int x : nums) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }
            return counts;
        }

        private int[] toPrimitiveArray(List<Integer> nums) {
            int[] result = new int[nums.size()];
            int i = 0;
            for (int x : nums) {
                result[i++] = x;
            }
            return result;
        }
    }

    // O(max(N1 * logN1, N2 * logN2)) time | O(1) extra space
    class IntersectionOfTwoArrays2UsingSorting implements IntersectionOfTwoArrays2 {

        @Override
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int i = 0;
            int j = 0;
            List<Integer> result = new ArrayList<>();
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    int t1 = times(nums1, i);
                    i += t1;
                } else if (nums1[i] > nums2[j]) {
                    int t2 = times(nums2, j);
                    j += t2;
                } else {
                    int t1 = times(nums1, i);
                    int t2 = times(nums2, j);
                    int numCopies = Math.min(t1, t2);
                    while (numCopies-- > 0) {
                        result.add(nums1[i]);
                    }
                    i += t1;
                    j += t2;
                }
            }
            return toPrimitiveArray(result);
        }

        // Number of times nums[idx] appears starting from index idx
        private int times(int[] nums, int idx) {
            int times = 1;
            int i = idx + 1;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                times++;
                i++;
            }
            return times;
        }

        private int[] toPrimitiveArray(List<Integer> nums) {
            int[] result = new int[nums.size()];
            int i = 0;
            for (int x : nums) {
                result[i++] = x;
            }
            return result;
        }
    }
}
