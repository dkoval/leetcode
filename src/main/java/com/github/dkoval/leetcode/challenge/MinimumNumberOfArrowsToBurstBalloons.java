package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

public abstract class MinimumNumberOfArrowsToBurstBalloons {

    public abstract int findMinArrowShots(int[][] points);

    public static class MinimumNumberOfArrowsToBurstBalloonsSortByEndPoint extends MinimumNumberOfArrowsToBurstBalloons {

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
}
