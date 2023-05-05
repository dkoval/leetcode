package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/dota2-senate/">Dota2 Senate</a>
 * <p>
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 * <p>
 * The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game.
 * The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
 * <ul>
 *  <li>Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.</li>
 *  <li>Announce the victory: If this senator found the senators who still have rights to vote are all from the same party,
 *  he can announce the victory and decide on the change in the game.</li>
 * </ul>
 * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party.
 * Then if there are n senators, the size of the given string will be n.
 * <p>
 * The round-based procedure starts from the first senator to the last senator in the given order.
 * This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 * <p>
 * Suppose every senator is smart enough and will play the best strategy for his own party.
 * Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == senate.length</li>
 *  <li>1 <= n <= 10^4</li>
 *  <li>senate[i] is either 'R' or 'D'</li>
 * </ul>
 */
public interface Dota2Senate {

    String predictPartyVictory(String senate);

    class Dota2SenateRev1 implements Dota2Senate {

        @Override
        public String predictPartyVictory(String senate) {
            // idea: greedy
            int n = senate.length();

            // senators[0] - members of the senate representing the Radiant party
            // senators[1] - members of the senate representing the Dire party
            Queue<Integer>[] senators = new Queue[]{new ArrayDeque<>(), new ArrayDeque<>()};
            for (int i = 0; i < n; i++) {
                int party = senate.charAt(i) == 'R' ? 0 : 1;
                senators[party].offer(i);
            }

            while (!senators[0].isEmpty() && !senators[1].isEmpty()) {
                int r = senators[0].poll();
                int d = senators[1].poll();
                // block an opponent to the right
                if (r < d) {
                    senators[0].offer(d + n);
                } else {
                    senators[1].offer(r + n);
                }
            }
            return senators[1].isEmpty() ? "Radiant" : "Dire";
        }
    }
}
