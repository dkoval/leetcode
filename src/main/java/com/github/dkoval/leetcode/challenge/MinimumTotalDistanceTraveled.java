package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-total-distance-traveled/">Minimum Total Distance Traveled (Hard)</a>
 * <p>
 * There are some robots and factories on the X-axis. You are given an integer array robot where robot[i] is the position
 * of the ith robot. You are also given a 2D integer array factory where factory[j] = [positionj, limitj] indicates that
 * positionj is the position of the jth factory and that the jth factory can repair at most limitj robots.
 * <p>
 * The positions of each robot are unique. The positions of each factory are also unique. Note that a robot can be
 * in the same position as a factory initially.
 * <p>
 * All the robots are initially broken; they keep moving in one direction. The direction could be the negative or
 * the positive direction of the X-axis. When a robot reaches a factory that did not reach its limit,
 * the factory repairs the robot, and it stops moving.
 * <p>
 * At any moment, you can set the initial direction of moving for some robot. Your target is to minimize the total distance
 * traveled by all the robots.
 * <p>
 * Return the minimum total distance traveled by all the robots. The test cases are generated such that all the robots
 * can be repaired.
 * <p>
 * Note that
 * <ul>
 *  <li>All robots move at the same speed.</li>
 *  <li>If two robots move in the same direction, they will never collide.</li>
 *  <li>If two robots move in opposite directions and they meet at some point, they do not collide. They cross each other.</li>
 *  <li>If a robot passes by a factory that reached its limits, it crosses it as if it does not exist.</li>
 *  <li>If the robot moved from a position x to a position y, the distance it moved is |y - x|.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= robot.length, factory.length <= 100</li>
 *  <li>factory[j].length == 2</li>
 *  <li>-10^9 <= robot[i], positionj <= 10^9</li>
 *  <li>0 <= limitj <= robot.length</li>
 *  <li>The input will be generated such that it is always possible to repair every robot.</li>
 * </ul>
 */
public interface MinimumTotalDistanceTraveled {

    long minimumTotalDistance(List<Integer> robot, int[][] factory);

    class MinimumTotalDistanceTraveledRev1 implements MinimumTotalDistanceTraveled {

        @Override
        public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
            int numRobots = robot.size();
            int numFactories = factory.length;

            // to minimize distance between robots and factories,
            // sort robots and factories by position
            robot.sort(Comparator.naturalOrder());
            Arrays.sort(factory, Comparator.comparingInt(it -> it[0]));

            // DP top-down
            Long[][] dp = new Long[numRobots][numFactories];
            return calc(robot, factory, 0, 0, dp);
        }

        private long calc(List<Integer> robot, int[][] factory, int robotIndex, int factoryIndex, Long[][] dp) {
            int numRobots = robot.size();
            int numFactories = factory.length;

            if (robotIndex == numRobots) {
                return 0;
            }

            if (factoryIndex == numFactories) {
                // there are more robots than all the factories can accept
                return Long.MAX_VALUE;
            }

            // already solved?
            if (dp[robotIndex][factoryIndex] != null) {
                return dp[robotIndex][factoryIndex];
            }

            // option #1: skip a factory at factoryIndex (accept no robots)
            long best = calc(robot, factory, robotIndex, factoryIndex + 1, dp);

            // option #2: accept x robots by a factory at factoryIndex
            long totalDist = 0;
            for (int count = 1; count <= factory[factoryIndex][1]; count++) {
                if (robotIndex + count > numRobots) {
                    break;
                }

                totalDist += Math.abs(factory[factoryIndex][0] - robot.get(robotIndex + count - 1));
                long res = calc(robot, factory, robotIndex + count, factoryIndex + 1, dp);
                if (res < Long.MAX_VALUE) {
                    best = Math.min(best, totalDist + res);
                }
            }
            return dp[robotIndex][factoryIndex] = best;
        }
    }
}
