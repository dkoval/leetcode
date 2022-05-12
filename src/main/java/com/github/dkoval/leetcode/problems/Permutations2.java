package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/permutations-ii/">Permutations II</a>
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public interface Permutations2 {

    List<List<Integer>> permuteUnique(int[] nums);

    class Permutations2RecursiveNaive implements Permutations2 {

        @Override
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> ans = new HashSet<>();
            generate(nums, 0, new ArrayList<>(), ans);
            return new ArrayList<>(ans);
        }

        private void generate(int[] nums, int idx, List<Integer> permutation, Set<List<Integer>> ans) {
            if (idx == nums.length) {
                ans.add(new ArrayList<>(permutation));
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                permutation.add(nums[i]);
                swap(nums, i, idx);

                generate(nums, idx + 1, permutation, ans);

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

    class Permutations2RecursiveWithSet implements Permutations2 {

        @Override
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            generate(nums, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void generate(int[] nums, int idx, List<Integer> permutation, List<List<Integer>> ans) {
            if (idx == nums.length) {
                ans.add(new ArrayList<>(permutation));
                return;
            }

            Set<Integer> seen = new HashSet<>();
            for (int i = idx; i < nums.length; i++) {
                if (seen.contains(nums[i]) ) {
                    continue;
                }

                seen.add(nums[i]);

                permutation.add(nums[i]);
                swap(nums, i, idx);

                generate(nums, idx + 1, permutation, ans);

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

    // Resource: https://www.youtube.com/watch?v=qhBVWf0YafA
    class Permutations2RecursiveWithGrouping implements Permutations2 {

        @Override
        public List<List<Integer>> permuteUnique(int[] nums) {
            // count occurrences of each number in nums[] to handle duplicates
            Map<Integer, Integer> counts = new HashMap<>();
            for (int x : nums) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }

            List<List<Integer>> ans = new ArrayList<>();
            doPermuteUnique(nums, counts, new ArrayList<>(), ans);
            return ans;
        }

        private void doPermuteUnique(int[] nums, Map<Integer, Integer> counts, List<Integer> permutation, List<List<Integer>> ans) {
            if (permutation.size() == nums.length) {
                ans.add(new ArrayList<>(permutation));
                return;
            }

            for (int x : counts.keySet()) {
                if (counts.get(x) > 0) {
                    permutation.add(x);
                    counts.put(x, counts.get(x) - 1);

                    doPermuteUnique(nums, counts, permutation, ans);

                    // backtrack
                    permutation.remove(permutation.size() - 1);
                    counts.put(x, counts.get(x) + 1);
                }
            }
        }
    }
}
