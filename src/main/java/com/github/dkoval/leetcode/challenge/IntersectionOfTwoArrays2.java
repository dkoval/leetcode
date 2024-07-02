package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">Intersection of Two Arrays II</a>
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
            int n1 = nums1.length;
            int n2 = nums2.length;

            Map<Integer, Integer> counts1 = counts(n1 < n2 ? nums1 : nums2);
            Map<Integer, Integer> counts2 = counts(n2 > n1 ? nums2 : nums1);

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
            int n = nums.size();
            int[] arr = new int[n];
            int i = 0;
            for (int x : nums) {
                arr[i++] = x;
            }
            return arr;
        }
    }

    // O(max(N1 * logN1, N2 * logN2)) time | O(1) extra space
    class IntersectionOfTwoArrays2UsingSorting implements IntersectionOfTwoArrays2 {

        @Override
        public int[] intersect(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int i = 0;
            int j = 0;
            List<Integer> result = new ArrayList<>();
            while (i < n1 && j < n2) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    result.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            return toPrimitiveArray(result);
        }

        private int[] toPrimitiveArray(List<Integer> nums) {
            int[] arr = new int[nums.size()];
            int i = 0;
            for (int x : nums) {
                arr[i++] = x;
            }
            return arr;
        }
    }
}
