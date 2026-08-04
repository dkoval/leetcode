package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-missing-elements/">Find Missing Elements</a>
 * <p>
 * You are given an integer array nums consisting of unique integers.
 * <p>
 * Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.
 * <p>
 * The smallest and largest integers of the original range are still present in nums.
 * <p>
 * Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface FindMissingElements {

    List<Integer> findMissingElements(int[] nums);

    class FindMissingElementsRev1 implements FindMissingElements {

        @Override
        public List<Integer> findMissingElements(int[] nums) {
            final var n = nums.length;

            Arrays.sort(nums);

            final var res = new ArrayList<Integer>();
            var i = 0;
            var curr = nums[0];
            while (curr < nums[n - 1]) {
                if (curr != nums[i]) {
                    res.add(curr);
                }
                if (curr >= nums[i]) {
                    i++;
                }
                curr++;
            }
            return res;
        }
    }
}
