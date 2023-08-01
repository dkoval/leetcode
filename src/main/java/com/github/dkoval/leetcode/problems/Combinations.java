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
public interface Combinations {

    List<List<Integer>> combine(int n, int k);

    class CombinationsRev1 implements Combinations {

        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            generate(nums(n), k, 0, new ArrayList<>(), ans);
            return ans;
        }

        private int[] nums(int n) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            return nums;
        }

        private void generate(int[] nums, int k, int idx, List<Integer> combination, List<List<Integer>> ans) {
            if (combination.size() == k) {
                ans.add(new ArrayList<>(combination));
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                combination.add(nums[i]);
                generate(nums, k, i + 1, combination, ans);
                combination.remove(combination.size() - 1);
            }
        }
    }

    class CombinationsRev2 implements Combinations {

        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            generate(n, k, 1, new ArrayList<>(), ans);
            return ans;
        }

        private void generate(int n, int k, int start, List<Integer> combination, List<List<Integer>> ans) {
            if (combination.size() == k) {
                ans.add(new ArrayList<>(combination));
                return;
            }

            for (int x = start; x <= n; x++) {
                combination.add(x);
                generate(n, k, x + 1, combination, ans);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
