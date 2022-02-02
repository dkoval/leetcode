package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">Permutations</a>
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 */
public interface Permutations {

    List<List<Integer>> permute(int[] nums);

    // Time: O(N^2 * N!)
    // Space: O(N * N!)
    class PermutationsRecursive implements Permutations {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            doPermute(listOf(nums), new ArrayList<>(), result);
            return result;
        }

        private List<Integer> listOf(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            return list;
        }

        private void doPermute(List<Integer> nums, List<Integer> permutation, List<List<Integer>> result) {
            if (nums.isEmpty()) {
                result.add(new ArrayList<>(permutation));
                return;
            }

            for (int i = 0; i < nums.size(); i++) {
                int num = nums.get(i);
                permutation.add(num);
                nums.remove(i); // removes element at index i
                doPermute(nums, permutation, result);
                // backtrack
                permutation.remove(permutation.size() - 1);
                nums.add(i, num);
            }
        }
    }


    // Time: O(N * N!)
    // Space: O(N * N!)
    class PermutationsRecursive2 implements Permutations {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            doPermute(nums, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void doPermute(int[] nums, int idx, List<Integer> permutation, List<List<Integer>> ans) {
            if (idx == nums.length) {
                ans.add(new ArrayList<>(permutation));
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                permutation.add(nums[i]); // put nums[i] in idx position
                swap(nums, idx, i);       // exclude nums[i] from the decision space in the next iteration

                doPermute(nums, idx + 1, permutation, ans);

                // backtrack
                permutation.remove(permutation.size() - 1);
                swap(nums, i, idx);
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i != j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    // Time: O(N * N!)
    // Space: O(N * N!)
    class PermutationsHeapAlgorithm implements Permutations {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            doPermute(listOf(nums), 0, result);
            return result;
        }

        private List<Integer> listOf(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            return list;
        }

        private void doPermute(List<Integer> nums, int idx, List<List<Integer>> result) {
            if (idx == nums.size() - 1) {
                result.add(new ArrayList<>(nums));
                return;
            }

            for (int i = idx; i < nums.size(); i++) {
                Collections.swap(nums, idx, i); // swap nums[idx] with every number after it
                doPermute(nums, idx + 1, result); // generate all permutations for sublist [idx + 1, n - 1]
                Collections.swap(nums, idx, i); // undo the swap to restore the original state
            }
        }
    }
}
