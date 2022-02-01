package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3837/">Subsets II</a>
 * <p>
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public interface Subsets2 {

    List<List<Integer>> subsetsWithDup(int[] nums);

    // Resource: https://www.youtube.com/watch?v=Vn2v6ajA7U0
    class Subsets2Recursive implements Subsets2 {

        @Override
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            doSubsetsWithDup(nums, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void doSubsetsWithDup(int[] nums, int idx, List<Integer> subset, List<List<Integer>> ans) {
            if (idx >= nums.length) {
                ans.add(new ArrayList<>(subset));
                return;
            }

            // option #1: take nums[idx]
            subset.add(nums[idx]);
            doSubsetsWithDup(nums, idx + 1, subset, ans);
            subset.remove(subset.size() - 1);

            // option #2: skip nums[idx] along with its duplicates to the right of idx
            while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
                idx++;
            }
            doSubsetsWithDup(nums, idx + 1, subset, ans);
        }
    }

    class Subsets2Recursive2 implements Subsets2 {

        @Override
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            doSubsetsWithDup(nums, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void doSubsetsWithDup(int[] nums, int idx, List<Integer> subset, List<List<Integer>> ans) {
            ans.add(new ArrayList<>(subset));
            for (int i = idx; i < nums.length; i++) {
                if (i > idx && nums[i] == nums[i - 1]) {
                    continue;
                }
                subset.add(nums[i]);
                doSubsetsWithDup(nums, i + 1, subset, ans);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
