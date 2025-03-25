package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/">Check if Grid can be Cut into Sections</a>
 * <p>
 * You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid.
 * You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy],
 * representing a rectangle on the grid. Each rectangle is defined as follows:
 * <ul>
 *  <li>(startx, starty): The bottom-left corner of the rectangle.</li>
 *  <li>(endx, endy): The top-right corner of the rectangle.</li>
 * </ul>
 * Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or
 * two vertical cuts on the grid such that:
 * <ul>
 *  <li>Each of the three resulting sections formed by the cuts contains at least one rectangle.</li>
 *  <li>Every rectangle belongs to exactly one section.</li>
 * </ul>
 * Return true if such cuts can be made; otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= n <= 10^9</li>
 *  <li>3 <= rectangles.length <= 10^5</li>
 *  <li>0 <= rectangles[i][0] < rectangles[i][2] <= n</li>
 *  <li>0 <= rectangles[i][1] < rectangles[i][3] <= n</li>
 *  <li>No two rectangles overlap.</li>
 * </ul>
 */
public interface CheckIfGridCanBeCutIntoSections {

    boolean checkValidCuts(int n, int[][] rectangles);

    class CheckIfGridCanBeCutIntoSectionsRev1 implements CheckIfGridCanBeCutIntoSections {

        @Override
        public boolean checkValidCuts(int n, int[][] rectangles) {
            final var intervalsOx = new ArrayList<int[]>();
            final var intervalsOy = new ArrayList<int[]>();
            for (var rectangle : rectangles) {
                intervalsOx.add(new int[]{rectangle[0], rectangle[2]});
                intervalsOy.add(new int[]{rectangle[1], rectangle[3]});
            }
            return canCut(intervalsOx) || canCut(intervalsOy);
        }

        private boolean canCut(List<int[]> intervals) {
            // merge overlapping intervals
            intervals.sort(Comparator.comparingInt(it -> it[0]));

            final var first = intervals.getFirst();
            var prev = new int[]{first[0], first[1]};
            var count = 1;
            for (int i = 1; i < intervals.size(); i++) {
                var curr = intervals.get(i);
                if (curr[0] < prev[1]) {
                    prev[1] = Math.max(prev[1], curr[1]);
                } else {
                    prev = curr;
                    if (++count == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
