package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/">Restore the Array From Adjacent Pairs</a>
 * <p>
 * There is an integer array nums that consists of n unique elements, but you have forgotten it.
 * However, you do remember every pair of adjacent elements in nums.
 * <p>
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that
 * the elements ui and vi are adjacent in nums.
 * <p>
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs,
 * either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]].
 * The pairs can appear in any order.
 * <p>
 * Return the original array nums. If there are multiple solutions, return any of them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>nums.length == n</li>
 *  <li>adjacentPairs.length == n - 1</li>
 *  <li>adjacentPairs[i].length == 2</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>-10^5 <= nums[i], ui, vi <= 10^5</li>
 *  <li>There exists some nums that has adjacentPairs as its pairs.</li>
 * </ul>
 */
public interface RestoreArrayFromAdjacentPairs {

    int[] restoreArray(int[][] adjacentPairs);

    class RestoreArrayFromAdjacentPairsRev1 implements RestoreArrayFromAdjacentPairs {

        @Override
        public int[] restoreArray(int[][] adjacentPairs) {
            // n >= 1
            int n = adjacentPairs.length;

            if (n == 1) {
                return adjacentPairs[0];
            }

            // Step #1: find the first (or last) element of nums[] - it only appears once in adjacentPairs[]
            // Step #2: perform DFS from the first (or last) element to restore nums[] from adjacent pairs (are similar to edges of a graph)
            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int[] pair : adjacentPairs) {
                adj.computeIfAbsent(pair[0], __ -> new ArrayList<>()).add(pair[1]);
                adj.computeIfAbsent(pair[1], __ -> new ArrayList<>()).add(pair[0]);
            }

            int first = 42;
            for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
                if (entry.getValue().size() == 1) {
                    first = entry.getKey();
                    break;
                }
            }

            int[] nums = new int[n + 1];
            Set<Integer> visited = new HashSet<>();
            dfs(adj, first, visited, nums, 0);
            return nums;
        }

        private void dfs(Map<Integer, List<Integer>> adj, int current, Set<Integer> visited, int[] nums, int index) {
            visited.add(current);
            nums[index] = current;
            for (int neighbor : adj.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    dfs(adj, neighbor, visited, nums, index + 1);
                }
            }
        }
    }

    class RestoreArrayFromAdjacentPairsRev2 implements RestoreArrayFromAdjacentPairs {

        @Override
        public int[] restoreArray(int[][] adjacentPairs) {
            // n >= 1
            int n = adjacentPairs.length;

            if (n == 1) {
                return adjacentPairs[0];
            }

            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int[] pair : adjacentPairs) {
                adj.computeIfAbsent(pair[0], __ -> new ArrayList<>()).add(pair[1]);
                adj.computeIfAbsent(pair[1], __ -> new ArrayList<>()).add(pair[0]);
            }

            int curr = 42;
            int end = 42;
            int count = 0;
            for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
                if (entry.getValue().size() == 1) {
                    if (count == 0) {
                        curr = entry.getKey();
                        count++;
                    } else if (count == 1) {
                        end = entry.getKey();
                        break;
                    }
                }
            }

            int i = 0;
            int[] nums = new int[n + 1];
            Integer prev = null;
            while (curr != end) {
                nums[i++] = curr;
                for (int next : adj.getOrDefault(curr, Collections.emptyList())) {
                    if (prev == null || next != prev) {
                        prev = curr;
                        curr = next;
                        break;
                    }
                }
            }
            nums[i] = end;
            return nums;
        }
    }
}
