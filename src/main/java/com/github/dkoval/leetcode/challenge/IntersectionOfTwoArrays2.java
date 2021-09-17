package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    // O(L1 + L2) time | O(L1 + L2) space
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
}
