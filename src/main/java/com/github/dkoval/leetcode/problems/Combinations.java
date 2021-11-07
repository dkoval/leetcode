package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combinations/">Combinations</a>
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 20</li>
 *  <li>1 <= k <= n</li>
 * </ul>
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = generate(n);
        List<List<Integer>> ans = new ArrayList<>();
        doCombine(nums, k, 0, new ArrayList<>(), ans);
        return ans;
    }

    private int[] generate(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    private void doCombine(int[] nums, int k, int idx, List<Integer> combination, List<List<Integer>> ans) {
        if (combination.size() == k) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            combination.add(nums[i]);
            doCombine(nums, k, i + 1, combination, ans);
            combination.remove(combination.size() - 1);
        }
    }
}
