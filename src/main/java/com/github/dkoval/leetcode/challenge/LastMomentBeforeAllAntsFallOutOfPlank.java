package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/">Last Moment Before All Ants Fall Out of a Plank</a>
 * <p>
 * We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second.
 * Some of the ants move to the left, the other move to the right.
 * <p>
 * When two ants moving in two different directions meet at some point, they change their directions and continue moving again.
 * Assume changing directions does not take any additional time.
 * <p>
 * When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.
 * <p>
 * Given an integer n and two integer arrays left and right, the positions of the ants moving to the left and the right,
 * return the moment when the last ant(s) fall out of the plank.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^4</li>
 *  <li>0 <= left.length <= n + 1</li>
 *  <li>0 <= left[i] <= n</li>
 *  <li>0 <= right.length <= n + 1</li>
 *  <li>0 <= right[i] <= n</li>
 *  <li>1 <= left.length + right.length <= n + 1</li>
 *  <li>All values of left and right are unique, and each value can appear only in one of the two arrays.</li>
 * </ul>
 */
public interface LastMomentBeforeAllAntsFallOutOfPlank {

    int getLastMoment(int n, int[] left, int[] right);

    // O(L + R) time | O(1) space
    class LastMomentBeforeAllAntsFallOutOfPlankRev1 implements LastMomentBeforeAllAntsFallOutOfPlank {

        @Override
        public int getLastMoment(int n, int[] left, int[] right) {
            // Hint: the ants change their way when they meet is equivalent to continue moving without changing their direction.
            // 0, ..., <-, <-, ... <-, ...
            // |--------------------|
            //                      ^ max position in left[]
            int maxLeft = 0;
            for (int x : left) {
                maxLeft = Math.max(maxLeft, x);
            }

            // ..., ->, ..., ->, ..., n
            //      |-----------------|
            //      ^ min position in right[]
            int minRight = n;
            for (int x : right) {
                minRight = Math.min(minRight, x);
            }

            // farthest distance
            return Math.max(maxLeft, n - minRight);
        }
    }
}
