package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">Combination Sum</a>
 * <p>
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
 * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
 * of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= candidates.length <= 30</li>
 *  <li>1 <= candidates[i] <= 200</li>
 *  <li>All elements of candidates are distinct</li>
 *  <li>1 <= target <= 500</li>
 * </ul>
 */
public interface CombinationSum {

    List<List<Integer>> combinationSum(int[] candidates, int target);

    class CombinationSumRev1 implements CombinationSum {

        // O(2^T) time, where T = target
        // Resource: https://www.youtube.com/watch?v=GBKI9VSKdGg
        @Override
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(candidates, target, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void backtrack(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> ans) {
            if (target == 0) {
                ans.add(new ArrayList<>(combination));
                return;
            }

            if (idx >= candidates.length) {
                return;
            }

            // option #1: add candidates[idx] to the current combination
            if (candidates[idx] <= target) {
                combination.add(candidates[idx]);
                backtrack(candidates, target - candidates[idx], idx, combination, ans);
                combination.remove(combination.size() - 1);
            }

            // option #2: ignore candidates[idx]
            backtrack(candidates, target, idx + 1, combination, ans);
        }
    }

    class CombinationSumRev2 implements CombinationSum {

        @Override
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(0, candidates, target, new ArrayList<>(), ans);
            return ans;
        }

        private void backtrack(int idx, int[] candidates, int target, List<Integer> combination, List<List<Integer>> ans) {
            if (target == 0) {
                ans.add(new ArrayList<>(combination));
                return;
            }

            for (int i = idx; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    combination.add(candidates[i]);
                    backtrack(i, candidates, target - candidates[i], combination, ans);
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }
}
