package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/water-and-jug-problem/">Water and Jug Problem</a>
 * <p>
 * You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available.
 * Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.
 * <p>
 * If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
 * <p>
 * Constraints:
 * <p>
 * 1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10^6
 */
public interface WaterAndJugProblem {

    boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity);

    class WaterAndJugProblemBFSSlow implements WaterAndJugProblem {

        private static class Node {
            final int jug1Amount;
            final int jug2Amount;

            Node(int jug1Amount, int jug2Amount) {
                this.jug1Amount = jug1Amount;
                this.jug2Amount = jug2Amount;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || obj.getClass() != Node.class) {
                    return false;
                }
                Node that = (Node) obj;
                return (that.jug1Amount == jug1Amount) && (that.jug2Amount == jug2Amount);
            }

            public int hashCode() {
                return Objects.hash(jug1Amount, jug2Amount);
            }
        }

        @Override
        public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
            if (targetCapacity > jug1Capacity + jug2Capacity) {
                return false;
            }

            // BFS
            Queue<Node> q = new ArrayDeque<>();
            Set<Node> visited = new HashSet<>();
            enqueue(q, new Node(0, 0), visited);
            while (!q.isEmpty()) {
                Node curr = q.poll();
                if (curr.jug1Amount == targetCapacity
                        || curr.jug2Amount == targetCapacity
                        || curr.jug1Amount + curr.jug2Amount == targetCapacity) {
                    return true;
                }

                // Operation #1: fill any of the jugs with water
                if (curr.jug1Amount < jug1Capacity) {
                    enqueue(q, new Node(jug1Capacity, curr.jug2Amount), visited);
                }

                if (curr.jug2Amount < jug2Capacity) {
                    enqueue(q, new Node(curr.jug1Amount, jug2Capacity), visited);
                }

                // Operation #2: empty any of the jugs
                if (curr.jug1Amount > 0) {
                    enqueue(q, new Node(0, curr.jug2Amount), visited);
                }

                if (curr.jug2Amount > 0) {
                    enqueue(q, new Node(curr.jug1Amount, 0), visited);
                }

                // Operation #3: pour water from one jug into another till the other jug is completely full, or the first jug itself is empty
                if (curr.jug1Amount < jug1Capacity && curr.jug2Amount > 0) {
                    // pour from jug2 into jug1
                    int delta = Math.min(jug1Capacity - curr.jug1Amount, curr.jug2Amount);
                    enqueue(q, new Node(curr.jug1Amount + delta, curr.jug2Amount - delta), visited);
                }

                if (curr.jug2Amount < jug2Capacity && curr.jug1Amount > 0) {
                    // pour from jug1 into jug2
                    int delta = Math.min(curr.jug1Amount, jug2Capacity - curr.jug2Amount);
                    enqueue(q, new Node(curr.jug1Amount - delta, curr.jug2Amount + delta), visited);
                }
            }
            return false;
        }

        private void enqueue(Queue<Node> q, Node node, Set<Node> visited) {
            if (!visited.contains(node)) {
                q.offer(node);
                visited.add(node);
            }
        }
    }
}
