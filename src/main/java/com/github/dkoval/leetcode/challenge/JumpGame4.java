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
public class JumpGame4 {

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        // groups indices having the same arr[i] value
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groups.computeIfAbsent(arr[i], __ -> new ArrayList<>()).add(i);
        }

        // BFS
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        int numSteps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1) {
                    return numSteps;
                }

                // add adjacent indices to the queue
                if (i - 1 >= 0 && !visited[i - 1]) {
                    q.offer(i - 1);
                    visited[i - 1] = true;
                }

                if (i + 1 < n && !visited[i + 1]) {
                    q.offer(i + 1);
                    visited[i + 1] = true;
                }

                if (groups.containsKey(arr[i])) {
                    List<Integer> indices = groups.get(arr[i]);
                    for (int j : indices) {
                        if (!visited[j]) {
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                    groups.remove(arr[i]);
                }
            }
            numSteps++;
        }
        return -1;
    }
}
