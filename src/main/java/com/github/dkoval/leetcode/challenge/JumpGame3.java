package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/jump-game-iii/">Jump Game III</a>
 * <p>
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 5 * 10^4</li>
 *  <li>0 <= arr[i] < arr.length</li>
 *  <li>0 <= start < arr.length</li>
 * </ul>
 */
public interface JumpGame3 {

    boolean canReach(int[] arr, int start);

    // O(N) time | O(N) space
    class JumpGame3DFS implements JumpGame3 {

        public boolean canReach(int[] arr, int start) {
            return dfs(arr, start, new HashSet<>());
        }

        private boolean dfs(int[] arr, int idx, Set<Integer> visited) {
            if (idx < 0 || idx >= arr.length || visited.contains(idx)) {
                return false;
            }

            if (arr[idx] == 0) {
                return true;
            }

            // mark the current index as visited to avoid going in cycles
            visited.add(idx);

            // check if we can reach to any index with value 0 by jumping arr[i] steps in both directions
            return dfs(arr, idx + arr[idx], visited) || dfs(arr, idx - arr[idx], visited);
        }
    }

    // O(N) time | O(N) space
    class JumpGame3BFS implements JumpGame3 {

        @Override
        public boolean canReach(int[] arr, int start) {
            int n = arr.length;
            // BFS
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            q.offer(start);
            visited.add(start);
            while (!q.isEmpty()) {
                int currIdx = q.poll();
                if (arr[currIdx] == 0) {
                    return true;
                }

                for (int nextIdx : Arrays.asList(currIdx + arr[currIdx], currIdx - arr[currIdx])) {
                    if (nextIdx < 0 || nextIdx >= n || visited.contains(nextIdx)) {
                        continue;
                    }
                    visited.add(nextIdx);
                    q.offer(nextIdx);
                }
            }
            return false;
        }
    }
}
