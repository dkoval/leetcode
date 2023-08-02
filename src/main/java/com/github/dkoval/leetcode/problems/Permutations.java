package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">Permutations</a>
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 6</li>
 *  <li>-10 <= nums[i] <= 10</li>
 *  <li>All the integers of nums are unique.</li>
 * </ul>
 */
public interface Permutations {

    List<List<Integer>> permute(int[] nums);

    // Time: O(N^2 * N!)
    // Space: O(N * N!)
    class PermutationsRecursiveRev1 implements Permutations {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            generate(listOf(nums), new ArrayList<>(), result);
            return result;
        }

        private List<Integer> listOf(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            return list;
        }

        private void generate(List<Integer> nums, List<Integer> permutation, List<List<Integer>> result) {
            if (nums.isEmpty()) {
                result.add(new ArrayList<>(permutation));
                return;
            }

            for (int i = 0; i < nums.size(); i++) {
                int num = nums.get(i);
                permutation.add(num);
                nums.remove(i); // removes element at index i

                generate(nums, permutation, result);

                // backtrack
                permutation.remove(permutation.size() - 1);
                nums.add(i, num);
            }
        }
    }


    // Time: O(N * N!)
    // Space: O(N * N!)
    class PermutationsRecursiveRev2 implements Permutations {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            generate(nums, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void generate(int[] nums, int idx, List<Integer> permutation, List<List<Integer>> ans) {
            int n = nums.length;

            if (idx == n) {
                ans.add(new ArrayList<>(permutation));
                return;
            }

            for (int i = idx; i < n; i++) {
                // add nums[i] to the current permutation (at index idx)
                permutation.add(nums[i]);
                // exclude nums[i] from the decision space in the next iteration
                swap(nums, idx, i);

                // proceed to the next index
                generate(nums, idx + 1, permutation, ans);

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
            generate(listOf(nums), 0, result);
            return result;
        }

        private List<Integer> listOf(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            return list;
        }

        private void generate(List<Integer> nums, int idx, List<List<Integer>> result) {
            if (idx == nums.size() - 1) {
                result.add(new ArrayList<>(nums));
                return;
            }

            for (int i = idx; i < nums.size(); i++) {
                Collections.swap(nums, idx, i); // swap nums[idx] with every number after it
                generate(nums, idx + 1, result); // generate all permutations for sublist [idx + 1, n - 1]
                Collections.swap(nums, idx, i); // undo the swap to restore the original state
            }
        }
    }
}
