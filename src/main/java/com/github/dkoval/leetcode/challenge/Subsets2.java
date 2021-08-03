package com.github.dkoval.leetcode.challenge;

import java.util.*;

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
        Set<List<Integer>> result = new LinkedHashSet<>();
        result.add(Collections.emptyList());

        for (int num : nums) {
            Set<List<Integer>> newSubsets = new LinkedHashSet<>();
            for (List<Integer> subset : result) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }
        return new ArrayList<>(result);
    }
}
