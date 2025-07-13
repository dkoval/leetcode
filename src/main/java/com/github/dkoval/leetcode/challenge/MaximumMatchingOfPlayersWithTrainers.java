package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-matching-of-players-with-trainers/">Maximum Matching of Players With Trainers</a>
 * <p>
 * You are given a 0-indexed integer array players, where players[i] represents the ability of the ith player.
 * You are also given a 0-indexed integer array trainers, where trainers[j] represents the training capacity of the jth trainer.
 * <p>
 * The ith player can match with the jth trainer if the player's ability is less than or equal to the trainer's training capacity.
 * Additionally, the ith player can be matched with at most one trainer, and the jth trainer can be matched with at most one player.
 * <p>
 * Return the maximum number of matchings between players and trainers that satisfy these conditions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= players.length, trainers.length <= 10^5</li>
 *  <li>1 <= players[i], trainers[j] <= 10^9</li>
 * </ul>
 */
public interface MaximumMatchingOfPlayersWithTrainers {

    int matchPlayersAndTrainers(int[] players, int[] trainers);

    class MaximumMatchingOfPlayersWithTrainersRev1 implements MaximumMatchingOfPlayersWithTrainers {

        @Override
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            // greedy
            Arrays.sort(players);
            Arrays.sort(trainers);

            var count = 0;
            var tIndex = 0;
            for (var p : players) {
                while (tIndex < trainers.length && trainers[tIndex] < p) {
                    tIndex++;
                }

                if (tIndex < trainers.length) {
                    count++;
                    tIndex++;
                } else {
                    break;
                }
            }
            return count;
        }
    }
}
