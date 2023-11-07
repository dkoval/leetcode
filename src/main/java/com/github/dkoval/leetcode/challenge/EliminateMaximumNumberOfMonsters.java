package com.github.dkoval.leetcode.challenge;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/eliminate-maximum-number-of-monsters/">Eliminate Maximum Number of Monsters</a>
 * <p>
 * You are playing a video game where you are defending your city from a group of n monsters.
 * You are given a 0-indexed integer array dist of size n, where dist[i] is the initial distance in kilometers of the ith monster from the city.
 * <p>
 * The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an integer array speed of size n,
 * where speed[i] is the speed of the ith monster in kilometers per minute.
 * <p>
 * You have a weapon that, once fully charged, can eliminate a single monster. However, the weapon takes one minute to charge.
 * The weapon is fully charged at the very start.
 * <p>
 * You lose when any monster reaches your city. If a monster reaches the city at the exact moment the weapon is fully charged,
 * it counts as a loss, and the game ends before you can use your weapon.
 * <p>
 * Return the maximum number of monsters that you can eliminate before you lose, or n if you can eliminate all the monsters before they reach the city.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == dist.length == speed.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= dist[i], speed[i] <= 10^5</li>
 * </ul>
 */
public interface EliminateMaximumNumberOfMonsters {

    int eliminateMaximum(int[] dist, int[] speed);

    // O(N * logN) time | O(N) space
    class EliminateMaximumNumberOfMonstersRev1 implements EliminateMaximumNumberOfMonsters {

        @Override
        public int eliminateMaximum(int[] dist, int[] speed) {
            int n = dist.length;

            Queue<Double> minHeap = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                minHeap.offer((double) dist[i] / speed[i]);
            }

            int weaponReadyTime = 0;
            int monsters = 0;
            while (!minHeap.isEmpty()) {
                double attackTime = minHeap.poll();
                if (weaponReadyTime < attackTime) {
                    monsters++;
                    weaponReadyTime++;
                } else {
                    break;
                }
            }
            return monsters;
        }
    }
}
