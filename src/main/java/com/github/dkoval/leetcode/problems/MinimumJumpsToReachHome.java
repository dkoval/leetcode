package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-jumps-to-reach-home/">Minimum Jumps to Reach Home</a>
 * <p>
 * A certain bug's home is on the x-axis at position x. Help them get there from position 0.
 * <p>
 * The bug jumps according to the following rules:
 * <p>
 * It can jump exactly a positions forward (to the right).
 * It can jump exactly b positions backward (to the left).
 * It cannot jump backward twice in a row.
 * It cannot jump to any forbidden positions.
 * The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
 * <p>
 * Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i],
 * and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home.
 * If there is no possible sequence of jumps that lands the bug on position x, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= forbidden.length <= 1000</li>
 *  <li>1 <= a, b, forbidden[i] <= 2000</li>
 *  <li>0 <= x <= 2000</li>
 *  <li>All the elements in forbidden are distinct</li>
 *  <li>Position x is not forbidden</li>
 * </ul>
 */
public interface MinimumJumpsToReachHome {

    int minimumJumps(int[] forbidden, int a, int b, int x);

    class MinimumJumpsToReachHomeBFS implements MinimumJumpsToReachHome {

        private static class Node {
            final int idx;
            final boolean canJumpBackward;

            Node(int idx, boolean canJumpBackward) {
                this.idx = idx;
                this.canJumpBackward = canJumpBackward;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Node node = (Node) o;
                return (idx == node.idx) && (canJumpBackward == node.canJumpBackward);
            }

            @Override
            public int hashCode() {
                return Objects.hash(idx, canJumpBackward);
            }
        }

        @Override
        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            Set<Integer> forb = new HashSet<>();
            for (int idx : forbidden) {
                forb.add(idx);
            }

            // From this position the bug can only get to a valid index <= x
            // by performing 2 consecutive backward jumps, which is prohibited.
            // According to the problem's constraints, the maximum value of x = 2000.
            int furthestIdx = 2000 + 2 * b;

            // BFS
            int numMoves = 0;
            Queue<Node> q = new ArrayDeque<>();
            Set<Node> visited = new HashSet<>();
            q.offer(new Node(0, true));
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    Node curr = q.poll();
                    if (curr.idx == x) {
                        return numMoves;
                    }

                    // options #1: jump forward
                    int forwardIdx = curr.idx + a;
                    if (forwardIdx < furthestIdx && !forb.contains(forwardIdx)) {
                        Node next = new Node(forwardIdx, true);
                        if (!visited.contains(next)) {
                            q.offer(next);
                            visited.add(next);
                        }
                    }

                    // option #2: jump backward but avoid 2 backward jumps in a row
                    if (curr.canJumpBackward) {
                        int backwardIdx = curr.idx - b;
                        if (backwardIdx >= 0 && !forb.contains(backwardIdx)) {
                            Node next = new Node(backwardIdx, false);
                            if (!visited.contains(next)) {
                                q.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
                numMoves++;
            }
            return -1;
        }
    }
}
