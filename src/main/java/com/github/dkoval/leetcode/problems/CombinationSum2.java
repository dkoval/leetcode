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

    // Resource: https://www.youtube.com/watch?v=rSA3t6BDDwg
    class CombinationSum2Recursive implements CombinationSum2 {

        @Override
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // this will allow us to handle duplicates
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            genCombinationSum2(candidates, target, 0, new ArrayList<>(), result);
            return result;
        }

        private void genCombinationSum2(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> result) {
            int n = candidates.length;
            if (target == 0) {
                result.add(new ArrayList<>(combination));
                return;
            }

            for (int i = idx; i < n; i++) {
                // ..., 1, 1, 1, 1, 1, ...,
                //      ^
                // skip over duplicates as they were already processed at this stage
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                if (candidates[i] > target) {
                    // since candidates[] is sorted, all element to the right of candidates[i] are also > target,
                    // therefore it makes sense to terminate early here
                    break;
                }

                combination.add(candidates[i]);
                genCombinationSum2(candidates, target - candidates[i], i + 1, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
