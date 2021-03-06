package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">Permutations</a>
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 */
public abstract class Permutations {

    public abstract List<List<Integer>> permute(int[] nums);

    // Time: O(N^2 * N!)
    // Space: O(N * N!)
    public static class PermutationsRecursive extends Permutations {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> availableNums = new ArrayList<>();
            for (int num : nums) {
                availableNums.add(num);
            }
            List<List<Integer>> result = new ArrayList<>();
            doPermute(new ArrayList<>(), availableNums, result);
            return result;
        }

        private void doPermute(List<Integer> perm, List<Integer> availableNums, List<List<Integer>> result) {
            if (availableNums.isEmpty()) {
                result.add(new ArrayList<>(perm));
                return;
            }
            for (int i = 0; i < availableNums.size(); i++) {
                int num = availableNums.get(i);
                perm.add(num);
                availableNums.remove(i); // removes element at index i
                doPermute(perm, availableNums, result);
                // backtrack
                perm.remove(perm.size() - 1);
                availableNums.add(i, num);
            }
        }
    }

    // Time: O(N * N!)
    // Space: O(N * N!)
    public static class PermutationsHeapAlgorithm extends Permutations {

        @Override
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
                Collections.swap(nums, i, j); // swap nums[i] with every number after it
                permute(nums, i + 1, result); // generate all permutations for sublist [i + 1, n - 1]
                Collections.swap(nums, i, j); // undo the swap to restore the original state
            }
        }
    }
}
