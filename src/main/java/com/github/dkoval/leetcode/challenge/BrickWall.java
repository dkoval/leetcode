package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3717/">Brick Wall</a>
 * <p>
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and
 * cross the least bricks.
 * <p>
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick
 * in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to
 * draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously
 * cross no bricks.
 * <p>
 * Note:
 * <ul>
 *  <li>The width sum of bricks in different rows are the same and won't exceed INT_MAX.</li>
 *  <li>The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000].</li>
 *  <li>Total number of bricks of the wall won't exceed 20,000.</li>
 * </ul>
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int maxNumUntouchedBricks = 0;
        // Idea: represent each brick in a row by its ending index, 0 - based.
        // Pair (idx, n) - total number n of bricks ending at index idx.
        Map<Integer, Integer> count = new HashMap<>();
        for (List<Integer> row : wall) {
            int endIdx = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                endIdx += row.get(i);
                // Now, if you put a vertical line at endIdx index, you get n untouched bricks among all the rows processed so far.
                // Our goal is to maximize the number of untouched bricks.
                int n = count.getOrDefault(endIdx, 0) + 1;
                count.put(endIdx, n);
                maxNumUntouchedBricks = Math.max(maxNumUntouchedBricks, n);
            }
        }
        return wall.size() - maxNumUntouchedBricks;
    }
}
