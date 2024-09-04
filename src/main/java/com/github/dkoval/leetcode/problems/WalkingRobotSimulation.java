package com.github.dkoval.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/walking-robot-simulation/">Walking Robot Simulation</a>
 * <p>
 * A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot can receive a sequence of these
 * three possible types of commands:
 * <ul>
 *  <li>-2: Turn left 90 degrees.</li>
 *  <li>-1: Turn right 90 degrees.</li>
 *  <li>1 <= k <= 9: Move forward k units, one unit at a time.</li>
 * </ul>
 * Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi).
 * If the robot runs into an obstacle, then it will instead stay in its current location and move on to the next command.
 * <p>
 * Return the maximum Euclidean distance that the robot ever gets from the origin squared
 * (i.e. if the distance is 5, return 25).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= commands.length <= 10^4</li>
 *  <li>commands[i] is either -2, -1, or an integer in the range [1, 9]</li>
 *  <li>0 <= obstacles.length <= 10^4</li>
 *  <li>-3 * 10^4 <= xi, yi <= 3 * 10^4</li>
 *  <li>The answer is guaranteed to be less than 2^31</li>
 * </ul>
 */
public interface WalkingRobotSimulation {

    int robotSim(int[] commands, int[][] obstacles);

    class WalkingRobotSimulationRev1 implements WalkingRobotSimulation {

        private static final Direction[] DIRS = {
                Direction.NORTH,
                Direction.EAST,
                Direction.SOUTH,
                Direction.WEST
        };

        @Override
        public int robotSim(int[] commands, int[][] obstacles) {
            Set<Cell> badCells = new HashSet<>();
            for (int[] obstacle : obstacles) {
                badCells.add(new Cell(obstacle[0], obstacle[1]));
            }

            // index in DIRS[]
            int d = 0;
            Cell curr = new Cell(0, 0);
            int best = 0;

            // run simulation
            for (int command : commands) {
                if (command > 0) {
                    // move forward
                    for (int step = 1; step <= command; step++) {
                        Cell next = curr.move(DIRS[d]);
                        if (!badCells.contains(next)) {
                            best = Math.max(best, next.x * next.x + next.y * next.y);
                            curr = next;
                        }
                    }
                } else if (command == -2) {
                    // turn left
                    if (--d < 0) {
                        d = DIRS.length - 1;
                    }
                } else if (command == -1) {
                    // turn right
                    d = (d + 1) % DIRS.length;
                }
            }
            return best;
        }

        private enum Direction {
            NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

            final int dx;
            final int dy;

            Direction(int dx, int dy) {
                this.dx = dx;
                this.dy = dy;
            }
        }

        private record Cell(int x, int y) {

            Cell move(Direction d) {
                return new Cell(x + d.dx, y + d.dy);
            }
        }
    }
}
