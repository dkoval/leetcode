package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">Permutations</a>
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        permute(numsList, 0, result);
        return result;
    }

    private void permute(List<Integer> nums, int i, List<List<Integer>> result) {
        if (i == nums.size() - 1) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int j = i; j < nums.size(); j++) {
            Collections.swap(nums, i, j);
            permute(nums, i + 1, result); // generate all permutations for sublist [i + 1, n - 1]
            Collections.swap(nums, i, j); // restore the original state
        }
    }
}
