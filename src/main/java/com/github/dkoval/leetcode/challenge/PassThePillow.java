package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/pass-the-pillow/">Pass the Pillow</a>
 * <p>
 * There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially.
 * Every second, the person holding the pillow passes it to the next person standing in the line.
 * Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.
 * <p>
 * For example, once the pillow reaches the nth person they pass it to the n - 1th person, then to the n - 2th person and so on.
 * Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 1000</li>
 *  <li>1 <= time <= 1000</li>
 * </ul>
 */
public interface PassThePillow {

    int passThePillow(int n, int time);

    class PassThePillowRev1 implements PassThePillow {

        @Override
        public int passThePillow(int n, int time) {
            int index = 1;
            int step = 1;
            while (time-- > 0) {
                if (index == 1) {
                    step = 1;
                } else if (index == n) {
                    step = -1;
                }
                index += step;
            }
            return index;
        }
    }
}
