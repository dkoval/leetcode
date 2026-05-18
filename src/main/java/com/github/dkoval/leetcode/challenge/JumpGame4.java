package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/jump-game-iv/">Jump Game IV</a>
 * <p>
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * <p>
 * In one step you can jump from index i to index:
 * <ul>
 *  <li>i + 1 where: i + 1 < arr.length.</li>
 *  <li>i - 1 where: i - 1 >= 0.</li>
 * <li>j where: arr[i] == arr[j] and i != j.</li>
 * </ul>
 * Return the minimum number of steps to reach the last index of the array.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 5 * 10^4</li>
 *  <li>-10^8 <= arr[i] <= 10^8</li>
 * </ul>
 */
public interface JumpGame4 {

    int minJumps(int[] arr);

    class JumpGame4BFS implements JumpGame4 {

        @Override
        public int minJumps(int[] arr) {
            final var n = arr.length;

            if (n <= 1) {
                return 0;
            }

            // arr[i] -> indices
            final var groups = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < n; i++) {
                groups.computeIfAbsent(arr[i], __ -> new ArrayList<>()).add(i);
            }

            // BFS
            final var q = new ArrayDeque<Integer>();
            final var visited = new boolean[n];
            enqueue(q, 0, visited);

            var steps = 0;
            while (!q.isEmpty()) {
                var size = q.size();
                while (size-- > 0) {
                    final var i = q.poll();

                    if (i == n - 1) {
                        return steps;
                    }

                    enqueue(q, i - 1, visited);
                    enqueue(q, i + 1, visited);

                    if (groups.containsKey(arr[i])) {
                        final var indices = groups.get(arr[i]);
                        for (var j : indices) {
                            enqueue(q, j, visited);
                        }
                        groups.remove(arr[i]);
                    }
                }
                steps++;
            }
            return -1;
        }

        private void enqueue(Queue<Integer> q, int i, boolean[] visited) {
            final var n = visited.length;
            if (i >= 0 && i < n && !visited[i]) {
                q.offer(i);
                visited[i] = true;
            }
        }
    }
}
