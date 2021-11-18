package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">Find All Numbers Disappeared in an Array</a>
 * <p>
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers
 * in the range [1, n] that do not appear in nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= nums[i] <= n</li>
 * </ul>
 */
public interface FindAllNumbersDisappearedInArray {

    List<Integer> findDisappearedNumbers(int[] nums);

    // O(N) time | O(N) extra space
    class FindAllNumbersDisappearedInArrayUsingSet implements FindAllNumbersDisappearedInArray {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            Set<Integer> unique = new HashSet<>();
            for (int x : nums) {
                unique.add(x);
            }

            int n = nums.length;
            List<Integer> ans = new ArrayList<>();
            for (int x = 1; x <= n; x++) {
                if (!unique.contains(x)) {
                    ans.add(x);
                }
            }
            return ans;
        }
    }

    // O(N) time | O(1) extra space
    class FindAllNumbersDisappearedInArrayNoExtraSpace implements FindAllNumbersDisappearedInArray {

        @Override
        public List<Integer> findDisappearedNumbers(int[] nums) {
            // nums[i] is in [1 : n], index is in [0 : n - 1], therefore
            // we can build direct correspondence between nums[] and indices[]
            int n = nums.length;
            for (int x : nums) {
                int idx = Math.abs(x) - 1;
                if (nums[idx] > 0) {
                    // mark as visited
                    nums[idx] *= -1;
                }
            }

            // index i for which nums[i] > 0 represent missing number (i + 1)
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }
}
