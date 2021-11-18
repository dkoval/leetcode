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
public class Subsets2 {

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
