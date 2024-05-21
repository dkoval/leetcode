package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 * <p>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10</li>
 *  <li>-10 <= nums[i] <= 10</li>
 *  <li>All the numbers of nums are unique</li>
 * </ul>
 */
public interface Subsets {

    List<List<Integer>> subsets(int[] nums);

    class SubsetsIter2 implements Subsets {

        @Override
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(List.of());
            for (int x : nums) {
                int size = ans.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> newSubset = new ArrayList<>(ans.get(i));
                    newSubset.add(x);
                    ans.add(newSubset);
                }
            }
            return ans;
        }
    }
}
