package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-maximum-sum-of-node-values/">Find the Maximum Sum of Node Values (Hard)</a>
 * <p>
 * There exists an undirected tree with n nodes numbered 0 to n - 1. You are given a 0-indexed 2D integer array edges of length n - 1,
 * where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the tree.
 * You are also given a positive integer k, and a 0-indexed array of non-negative integers nums of length n,
 * where nums[i] represents the value of the node numbered i.
 * <p>
 * Alice wants the sum of values of tree nodes to be maximum, for which Alice can perform the following operation any number of times (including zero) on the tree:
 * <
 * Choose any edge [u, v] connecting the nodes u and v, and update their values as follows:
 * <ul>
 *  <li>nums[u] = nums[u] XOR k</li>
 *  <li>nums[v] = nums[v] XOR k</li>
 * </ul>
 * Return the maximum possible sum of the values Alice can achieve by performing the operation any number of times.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n == nums.length <= 2 * 10^4</li>
 *  <li>1 <= k <= 10^9</li>
 *  <li>0 <= nums[i] <= 109</li>
 *  <li>edges.length == n - 1</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= edges[i][0], edges[i][1] <= n - 1</li>
 *  <li>The input is generated such that edges represent a valid tree.</li>
 * </ul>
 */
public interface FindMaximumSumOfNodeValues {

    long maximumValueSum(int[] nums, int k, int[][] edges);

    class FindMaximumSumOfNodeValuesRev1 implements FindMaximumSumOfNodeValues {

        @Override
        public long maximumValueSum(int[] nums, int k, int[][] edges) {
            var smallestGain = Long.MAX_VALUE;
            var smallestDrop = Long.MAX_VALUE;

            var count = 0;
            var total = 0L;
            for (var x : nums) {
                if ((x ^ k) > x) {
                    total += x ^ k;
                    count++;
                    smallestGain = Math.min(smallestGain, (x ^ k) - x);
                } else {
                    total += x;
                    smallestDrop = Math.min(smallestDrop, x - (x ^ k));
                }
            }

            final var delta = (count % 2 == 0) ? 0 : Math.min(smallestGain, smallestDrop);
            return total - delta;
        }
    }
}
