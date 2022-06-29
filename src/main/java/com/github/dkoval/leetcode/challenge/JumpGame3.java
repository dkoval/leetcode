package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

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
            int n = arr.length;
            return dfs(arr, start, new boolean[n]);
        }

        private boolean dfs(int[] arr, int idx, boolean[] visited) {
            if (idx < 0 || idx >= arr.length || visited[idx]) {
                return false;
            }

            if (arr[idx] == 0) {
                return true;
            }

            // mark the current index as visited to avoid going in cycles
            visited[idx] = true;

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
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            enqueue(q, start, n, visited);
            while (!q.isEmpty()) {
                int i = q.poll();
                if (arr[i] == 0) {
                    return true;
                }
                enqueue(q, i + arr[i], n, visited);
                enqueue(q, i - arr[i], n, visited);
            }
            return false;
        }

        private void enqueue(Queue<Integer> q, int i, int n, boolean[] visited) {
            if (i >= 0 && i < n && !visited[i]) {
                q.offer(i);
                visited[i] = true;
            }
        }
    }
}
