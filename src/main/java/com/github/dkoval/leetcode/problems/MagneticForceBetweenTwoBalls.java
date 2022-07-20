package com.github.dkoval.leetcode.problems;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/magnetic-force-between-two-balls/">Magnetic Force Between Two Balls</a>
 * <p>
 * In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.
 * Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets
 * such that the minimum magnetic force between any two balls is maximum.
 * <p>
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * <p>
 * Given the integer array position and the integer m. Return the required force.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == position.length</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>1 <= position[i] <= 10^9</li>
 *  <li>All integers in position are distinct</li>
 *  <li>2 <= m <= position.length</li>
 * </ul>
 */
public interface MagneticForceBetweenTwoBalls {

    int maxDistance(int[] position, int m);

    // O(N*logN) time | O(1) space
    class MagneticForceBetweenTwoBallsUsingBinarySearchRev1 implements MagneticForceBetweenTwoBalls {

        @Override
        public int maxDistance(int[] position, int m) {
            int n = position.length;
            Arrays.sort(position);

            // set lower and upper boundaries for the distance
            int left = 1;
            int right = position[n - 1] - position[0];
            int ans = 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (countBalls(position, mid, m) == m) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        private int countBalls(int[] position, int target, int m) {
            int count = 1;
            int lastPos = position[0];
            for (int i = 1; i < position.length && count < m; i++) {
                if (position[i] - lastPos >= target) {
                    // can place a ball at the current position[i]
                    // if the distance (i.e. minimum magnetic force) between the current and the last positions is >= target
                    count++;
                    lastPos = position[i];
                }
            }
            return count;
        }
    }

    // O(N*logN) time | O(1) space
    class MagneticForceBetweenTwoBallsUsingBinarySearchRev2 implements MagneticForceBetweenTwoBalls {

        @Override
        public int maxDistance(int[] position, int m) {
            int n = position.length;
            Arrays.sort(position);

            // set lower and upper boundaries for the distance
            int left = 1;
            int right = position[n - 1] - position[0];
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (countBalls(position, mid, m) == m) {
                    // mid might be the answer;
                    // check if there is a better option to the right of mid
                    left = mid;
                } else {
                    // mid is not the answer + everything to the right of it
                    right = mid - 1;
                }
            }
            return left;
        }

        private int countBalls(int[] position, int target, int m) {
            int count = 1;
            int lastPos = position[0];
            for (int i = 1; i < position.length && count < m; i++) {
                if (position[i] - lastPos >= target) {
                    // can place a ball at position[i]
                    count++;
                    lastPos = position[i];
                }
            }
            return count;
        }
    }
}