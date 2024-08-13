package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/">Combination Sum II</a>
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= candidates.length <= 100</li>
 *  <li>1 <= candidates[i] <= 50</li>
 *  <li>1 <= target <= 30</li>
 * </ul>
 */
public interface CombinationSum2 {

    List<List<Integer>> combinationSum2(int[] candidates, int target);

    class CombinationSum2Rev1 implements CombinationSum2 {

        @Override
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // this will allow us to handle duplicates
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(candidates, target, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void backtrack(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> ans) {
            if (target == 0) {
                ans.add(new ArrayList<>(combination));
                return;
            }

            int n = candidates.length;
            if (idx >= n) {
                return;
            }

            if (candidates[idx] > target) {
                // since candidates[] is sorted, all elements to the right of candidates[i] are also > target,
                // therefore it makes sense to early terminate here
                return;
            }

            // option #1: take candidates[idx]
            combination.add(candidates[idx]);
            backtrack(candidates, target - candidates[idx], idx + 1, combination, ans);
            combination.removeLast();

            // option #2: skip candidates[idx] along with its duplicates
            while (idx + 1 < n && candidates[idx + 1] == candidates[idx]) {
                idx++;
            }
            backtrack(candidates, target, idx + 1, combination, ans);
        }
    }

    // Resource: https://www.youtube.com/watch?v=rSA3t6BDDwg
    class CombinationSum2Rev2 implements CombinationSum2 {

        @Override
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // this will allow us to handle duplicates
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(candidates, target, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void backtrack(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> ans) {
            if (target == 0) {
                ans.add(new ArrayList<>(combination));
                return;
            }

            int n = candidates.length;
            for (int i = idx; i < n; i++) {
                // ..., 1, 1, 1, 1, 1, ...,
                //      ^
                // skip over duplicates as they were already processed at this stage
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                if (candidates[i] > target) {
                    // since candidates[] is sorted, all elements to the right of candidates[i] are also > target,
                    // therefore it makes sense to early terminate here
                    break;
                }

                combination.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, combination, ans);
                combination.removeLast();
            }
        }
    }
}
