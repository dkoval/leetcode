package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/build-a-matrix-with-conditions/">Build a Matrix With Conditions (Hard)</a>
 * <p>
 * You are given a positive integer k. You are also given:
 * <ul>
 *  <li>a 2D integer array rowConditions of size n where rowConditions[i] = [abovei, belowi], and</li>
 *  <li>a 2D integer array colConditions of size m where colConditions[i] = [lefti, righti].</li>
 * </ul>
 * The two arrays contain integers from 1 to k.
 * <p>
 * You have to build a k x k matrix that contains each of the numbers from 1 to k exactly once. The remaining cells should have the value 0.
 * <p>
 * The matrix should also satisfy the following conditions:
 * <ul>
 *  <li>The number abovei should appear in a row that is strictly above the row at which the number belowi appears for all i from 0 to n - 1.</li>
 *  <li>The number lefti should appear in a column that is strictly left of the column at which the number righti appears for all i from 0 to m - 1.</li>
 * </ul>
 * Return any matrix that satisfies the conditions. If no answer exists, return an empty matrix.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= k <= 400</li>
 *  <li>1 <= rowConditions.length, colConditions.length <= 10^4</li>
 *  <li>rowConditions[i].length == colConditions[i].length == 2</li>
 *  <li>1 <= abovei, belowi, lefti, righti <= k</li>
 *  <li>abovei != belowi</li>
 *  <li>lefti != righti</li>
 * </ul>
 */
public interface BuildMatrixWithConditions {

    int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions);

    class BuildMatrixWithConditionsRev1 implements BuildMatrixWithConditions {

        @Override
        public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
            // Idea: topological sort
            // Note that row and column conditions are independent, thus can be processed individually.

            // rows[i] = x -> x appears in the i-th row
            List<Integer> rows = topologicalSort(rowConditions, k);
            if (rows.size() != k) {
                return new int[0][0];
            }

            // cols[j] = y -> y appears in the j-th column
            List<Integer> cols = topologicalSort(colConditions, k);
            if (cols.size() != k) {
                return new int[0][0];
            }

            // k x k matrix that contains each of the numbers from 1 to k exactly once
            Map<Integer, Integer> numToRow = numToIndex(rows);
            Map<Integer, Integer> numToCol = numToIndex(cols);

            int[][] ans = new int[k][k];
            for (int x = 1; x <= k; x++) {
                int row = numToRow.get(x);
                int col = numToCol.get(x);
                ans[row][col] = x;
            }
            return ans;
        }

        private List<Integer> topologicalSort(int[][] conditions, int k) {
            // deps[i] - the list of elements that depend on i
            Map<Integer, List<Integer>> deps = new HashMap<>();
            int[] indegrees = new int[k + 1];
            for (int[] condition : conditions) {
                int u = condition[0];
                int v = condition[1];
                deps.computeIfAbsent(u, __ -> new ArrayList<>()).add(v);
                indegrees[v]++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= k; i++) {
                if (indegrees[i] == 0) {
                    q.offer(i);
                }
            }

            List<Integer> order = new ArrayList<>();
            while (!q.isEmpty()) {
                int curr = q.poll();
                order.add(curr);

                for (int next : deps.getOrDefault(curr, List.of())) {
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            return order;
        }

        private Map<Integer, Integer> numToIndex(List<Integer> nums) {
            Map<Integer, Integer> ans = new HashMap<>();
            for (int i = 0; i < nums.size(); i++) {
                ans.put(nums.get(i), i);
            }
            return ans;
        }
    }
}
