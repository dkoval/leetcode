package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3591/">Beautiful Arrangement</a>
 * <p>
 * Suppose you have n integers from 1 to n. We define a beautiful arrangement as an array that is constructed by
 * these n numbers successfully if one of the following is true for the ith position (1 <= i <= n) in this array:
 * <p>
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * <p>
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 */
public abstract class BeautifulArrangement {

    public abstract int countArrangement(int n);

    public static class BeautifulArrangementUsingDFSWithBacktracking extends BeautifulArrangement {

        @Override
        public int countArrangement(int n) {
            int[] nums = new int[n + 1];
            int[] result = {0};
            dfs(nums, 1, n, result);
            return result[0];
        }

        private void dfs(int[] nums, int val, int n, int[] result) {
            if (val > n) {
                result[0]++;
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (nums[i] == 0 && (val % i == 0 || i % val == 0)) {
                    nums[i] = val;
                    dfs(nums, val + 1, n, result);
                    nums[i] = 0; // backtrack
                }
            }
        }
    }

    public static class BeautifulArrangementBySwappingNumbers extends BeautifulArrangement {

        @Override
        public int countArrangement(int n) {
            int[] nums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nums[i] = i;
            }
            int[] result = {0};
            dfs(nums, n, result);
            return result[0];
        }

        private void dfs(int[] nums, int val, int[] result) {
            if (val == 0) {
                result[0]++;
                return;
            }
            for (int i = val; i > 0; i--) {
                swap(nums, i, val);
                if (nums[val] % val == 0 || val % nums[val] == 0) {
                    dfs(nums, val - 1, result);
                }
                swap(nums, i, val);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
