package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">Minimum Number of Arrows to Burst Balloons</a>
 * <p>
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend]
 * denotes a balloon whose horizontal diameter stretches between xstart and xend.
 * You do not know the exact y-coordinates of the balloons.
 * <p>
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
 * There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * <p>
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= points.length <= 10^5</li>
 *  <li>points[i].length == 2</li>
 *  <li>-2^31 <= xstart < xend <= 2^31 - 1</li>
 * </ul>
 */
public interface MinimumNumberOfArrowsToBurstBalloons {

    int findMinArrowShots(int[][] points);

    class MinimumNumberOfArrowsToBurstBalloonsSortByEndPoint implements MinimumNumberOfArrowsToBurstBalloons {

        @Override
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            Arrays.sort(points, Comparator.comparingInt(diameter -> diameter[1]));
            int count = 1;
            int arrowPos = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= arrowPos) continue;
                count++;
                arrowPos = points[i][1];
            }
            return count;
        }
    }

    class MinimumNumberOfArrowsToBurstBalloonsSortByStartPoint implements MinimumNumberOfArrowsToBurstBalloons {

        @Override
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            Arrays.sort(points, Comparator.comparingInt(delimiter -> delimiter[0]));
            int count = 1;
            int endPoint = points[0][1];
            for (int i = 1; i < points.length; i++) {
                endPoint = Math.min(endPoint, points[i][1]);
                if (points[i][0] > endPoint) {
                    count++;
                    endPoint = points[i][1];
                }
            }
            return count;
        }
    }

    // O(N * logN) time | O(1) space
    class MinimumNumberOfArrowsToBurstSweepLine implements MinimumNumberOfArrowsToBurstBalloons {

        private static class Event {
            int index;
            int x;
            boolean start;

            Event(int index, int x, boolean start) {
                this.index = index;
                this.x = x;
                this.start = start;
            }

            @Override
            public String toString() {
                return "Event{" +
                        "index=" + index +
                        ", x=" + x +
                        ", start=" + start +
                        '}';
            }
        }

        // Resource: https://www.youtube.com/watch?v=1E2fDvdfn-s
        @Override
        public int findMinArrowShots(int[][] points) {
            int n = points.length;

            // sweep line algorithm
            Event[] events = new Event[n * 2];
            for (int i = 0; i < n; i++) {
                events[i * 2] = new Event(i, points[i][0], true);
                events[i * 2 + 1] = new Event(i, points[i][1], false);
            }

            // if two events share the same x coordinate, START event must come first
            Comparator<Event> compareByX = Comparator.comparingInt(event -> event.x);
            Comparator<Event> compareByStart = Comparator.comparingInt(event -> event.start ? -1 : 1);
            Arrays.sort(events, compareByX.thenComparing(compareByStart));

            // number of used arrows
            int count = 0;
            // indices of already burst balloons
            boolean[] burst = new boolean[n];
            // indices of balloons yet to be burst
            List<Integer> balloons = new ArrayList<>();

            for (Event event : events) {
                if (event.start) {
                    balloons.add(event.index);
                } else {
                    if (burst[event.index]) {
                        continue;
                    }

                    for (int index : balloons) {
                        burst[index] = true;
                    }
                    balloons.clear();
                    count++;
                }
            }
            return count;
        }
    }
}
