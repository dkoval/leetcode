package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/">Next Greater Element I</a>
 * <p>
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * <p>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 * <p>
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length <= nums2.length <= 1000</li>
 *  <li>0 <= nums1[i], nums2[i] <= 104</li>
 *  <li>All integers in nums1 and nums2 are unique</li>
 *  <li>All the integers of nums1 also appear in nums2</li>
 * </ul>
 * <p>
 * Follow up: Could you find an O(nums1.length + nums2.length) solution?
 */
public interface NextGreaterElement1 {

    int[] nextGreaterElement(int[] nums1, int[] nums2);

    class NextGreaterElement1Naive implements NextGreaterElement1 {

        @Override
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            Map<Integer, Integer> val2idx = new HashMap<>();
            for (int i = 0; i < n2; i++) {
                val2idx.put(nums2[i], i);
            }

            int[] answer = new int[n1];
            Arrays.fill(answer, -1);

            for (int i = 0; i < n1; i++) {
                int idx = val2idx.get(nums1[i]);
                for (int k = idx + 1; k < n2; k++) {
                    if (nums2[k] > nums1[i]) {
                        answer[i] = nums2[k];
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
