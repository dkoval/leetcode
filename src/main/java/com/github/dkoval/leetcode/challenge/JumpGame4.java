package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3582/">Jump Game IV</a>
 * <p>
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * <p>
 * In one step you can jump from index i to index:
 * <ul>
 * <li>i + 1 where: i + 1 < arr.length.</li>
 * <li>i - 1 where: i - 1 >= 0.</li>
 * <li>j where: arr[i] == arr[j] and i != j.</li>
 * </ul>
 * Return the minimum number of steps to reach the last index of the array.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 */
public class JumpGame4 {

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            index.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }
        // BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        int numSteps = 0;
        q.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == arr.length - 1) {
                    return numSteps;
                }
                visited[i] = true;
                // add adjacent indices to the queue
                if (i - 1 >= 0 && !visited[i - 1]) {
                    q.offer(i - 1);
                }
                if (i + 1 <= arr.length - 1 && !visited[i + 1]) {
                    q.offer(i + 1);
                }
                List<Integer> next = index.get(arr[i]);
                if (next == null) continue;
                for (int j : next) {
                    if (!visited[j]) {
                        q.offer(j);
                    }
                }
                index.remove(arr[i]);
            }
            numSteps++;
        }
        return -1;
    }
}
