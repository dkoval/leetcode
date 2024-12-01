package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/valid-arrangement-of-pairs/">Valid Arrangement of Pairs (Hard)</a>
 * <p>
 * You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi].
 * An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.
 * <p>
 * Return any valid arrangement of pairs.
 * <p>
 * Note: The inputs will be generated such that there exists a valid arrangement of pairs.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= pairs.length <= 10^5</li>
 *  <li>pairs[i].length == 2</li>
 *  <li>0 <= starti, endi <= 10^9</li>
 *  <li>starti != endi</li>
 *  <li>No two pairs are exactly the same.</li>
 *  <li>There exists a valid arrangement of pairs.</li>
 * </ul>
 */
public interface ValidArrangementOfPairs {

    int[][] validArrangement(int[][] pairs);

    // Resource: https://www.youtube.com/watch?v=8MpoO2zA2l4
    class ValidArrangementOfPairsRev1 implements ValidArrangementOfPairs {

        private static int findStart(Map<Integer, Degrees> degrees) {
            // Property. The starting node has an extra outgoing edge:
            // in + 1 = out
            var start = -1;
            for (var entry : degrees.entrySet()) {
                var x = entry.getKey();
                var d = entry.getValue();
                if (d.in + 1 == d.out) {
                    return x;
                }
                start = x;
            }
            // all nodes have equal in/out degrees, return any node
            return start;
        }

        private static Deque<Integer> findEulerianPath(Map<Integer, Deque<Integer>> adj, int start) {
            var path = new ArrayDeque<Integer>();

            // modified DFS
            var stack = new ArrayDeque<Integer>();
            stack.push(start);

            while (!stack.isEmpty()) {
                var curr = stack.peek();
                if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                    var next = adj.get(curr).pollLast();
                    stack.push(next);
                } else {
                    // all outgoing edges of the current have been processed,
                    // add the current node to the path
                    path.offerFirst(stack.pop());
                }
            }
            return path;
        }

        private static int[][] formatPath(Deque<Integer> path) {
            var ans = new int[path.size() - 1][2];
            ans[0] = new int[]{path.pollFirst(), path.pollFirst()};

            int i = 1;
            while (!path.isEmpty()) {
                ans[i] = new int[]{ans[i - 1][1], path.pollFirst()};
                i++;
            }
            return ans;
        }

        @Override
        public int[][] validArrangement(int[][] pairs) {
            // Idea: find an Eulerian path
            var adj = new HashMap<Integer, Deque<Integer>>();
            var degrees = new HashMap<Integer, Degrees>();
            for (var pair : pairs) {
                adj.computeIfAbsent(pair[0], __ -> new ArrayDeque<>()).offerLast(pair[1]);
                degrees.computeIfAbsent(pair[0], __ -> new Degrees()).out++;
                degrees.computeIfAbsent(pair[1], __ -> new Degrees()).in++;
            }

            // find the starting node
            var start = findStart(degrees);

            // find an Eulerian path
            var path = findEulerianPath(adj, start);
            return formatPath(path);
        }

        private static class Degrees {
            int in = 0;
            int out = 0;
        }
    }
}
