package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-closest-person/">Find Closest Person</a>
 * <p>
 * You are given three integers x, y, and z, representing the positions of three people on a number line:
 * <ul>
 *  <li>x is the position of Person 1.</li>
 *  <li>y is the position of Person 2.</li>
 *  <li>z is the position of Person 3, who does not move.</li>
 * </ul>
 * Both Person 1 and Person 2 move toward Person 3 at the same speed.
 * <p>
 * Determine which person reaches Person 3 first:
 * <ul>
 *  <li>Return 1 if Person 1 arrives first.</li>
 *  <li>Return 2 if Person 2 arrives first.</li>
 *  <li>Return 0 if both arrive at the same time.</li>
 * </ul>
 * Return the result accordingly.
 * <p>
 * Constraints:
 * <p>
 * 1 <= x, y, z <= 100
 */
public interface FindClosestPerson {

    int findClosest(int x, int y, int z);

    class FindClosestPersonRev1 implements FindClosestPerson {

        @Override
        public int findClosest(int x, int y, int z) {
            final var diffX = Math.abs(x - z);
            final var diffY = Math.abs(y - z);
            return (diffX == diffY) ? 0 : (diffX < diffY) ? 1 : 2;
        }
    }
}
