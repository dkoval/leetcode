package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumJava implements CombinationSum {

    @NotNull
    @Override
    public List<List<Integer>> combinationSum(@NotNull int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateCombinations(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            combination.add(candidates[i]);
            generateCombinations(candidates, target - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1); // backtrack
        }
    }
}
