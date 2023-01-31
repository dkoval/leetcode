package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-team-with-no-conflicts/">Best Team With No Conflicts</a>
 * <p>
 * You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score.
 * The score of the team is the sum of scores of all the players in the team.
 * <p>
 * However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player.
 * A conflict does not occur between players of the same age.
 * <p>
 * Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively,
 * return the highest overall score of all possible basketball teams.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= scores.length, ages.length <= 1000</li>
 *  <li>scores.length == ages.length</li>
 *  <li>1 <= scores[i] <= 10^6</li>
 *  <li>1 <= ages[i] <= 1000</li>
 * </ul>
 */
public interface BestTeamWithNoConflicts {

    int bestTeamScore(int[] scores, int[] ages);

    class BestTeamWithNoConflictsDPBottomUp implements BestTeamWithNoConflicts {

        // O(N^2) time | O(N) space
        @Override
        public int bestTeamScore(int[] scores, int[] ages) {
            // somewhat similar to LIS problem
            int n = scores.length;
            Player[] players = new Player[n];
            for (int i = 0; i < n; i++) {
                players[i] = new Player(scores[i], ages[i]);
            }

            // sort players by their score in ASC order
            Arrays.sort(players, (p1, p2) -> (p1.score == p2.score) ? Integer.compare(p1.age, p2.age) : Integer.compare(p1.score, p2.score));

            // dp[i] - the highest overall score we can get if players[i].score was the maximum score
            int[] dp = new int[n];
            int best = players[0].score;
            for (int i = 0; i < n; i++) {
                dp[i] = players[i].score;
                for (int j = 0; j < i; j++) {
                    // since players[] is sorted, i-th player's score is >= than j-th player's one
                    if (players[j].age <= players[i].age) {
                        // no conflict, therefore can include players[i]'s score
                        dp[i] = Math.max(dp[i], players[i].score + dp[j]);
                    }
                }
                best = Math.max(best, dp[i]);
            }
            return best;
        }

        private static class Player {
            final int score;
            final int age;

            Player(int score, int age) {
                this.score = score;
                this.age = age;
            }
        }
    }
}
