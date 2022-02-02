package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/permutations-ii/">Permutations II</a>
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public interface Permutations2 {

    List<List<Integer>> permuteUnique(int[] nums);

    // Resource: https://www.youtube.com/watch?v=qhBVWf0YafA
    class Permutations2Recursive implements Permutations2 {

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
