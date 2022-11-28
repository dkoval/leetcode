package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/">Find Players With Zero or One Losses</a>
 * <p>
 * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 * <p>
 * Return a list answer of size 2 where:
 * <p>
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 * <p>
 * Note:
 * <p>
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= matches.length <= 10^5</li>
 *  <li>matches[i].length == 2</li>
 *  <li>1 <= winneri, loseri <= 10^5</li>
 *  <li>winneri != loseri</li>
 *  <li>All matches[i] are unique</li>
 * </ul>
 */
public interface FindPlayersWithZeroOrOneLosses {

    List<List<Integer>> findWinners(int[][] matches);

    class FindPlayersWithZeroOrOneLossesRev1 implements FindPlayersWithZeroOrOneLosses {

        @Override
        public List<List<Integer>> findWinners(int[][] matches) {
            // loser -> number of lost matches
            Map<Integer, Integer> losers = new HashMap<>();
            // all participated players
            Set<Integer> players = new HashSet<>();

            for (int[] match : matches) {
                int winner = match[0];
                int loser = match[1];

                players.add(winner);
                players.add(loser);

                losers.put(loser, losers.getOrDefault(loser, 0) + 1);
            }

            List<Integer> allPlayers = new ArrayList<>(players);
            Collections.sort(allPlayers);

            List<Integer> absoluteWinners = new ArrayList<>();
            List<Integer> lostExactlyOne = new ArrayList<>();
            for (int i : allPlayers) {
                if (!losers.containsKey(i)) {
                    absoluteWinners.add(i);
                } else if (losers.get(i) == 1) {
                    lostExactlyOne.add(i);
                }
            }
            return Arrays.asList(absoluteWinners, lostExactlyOne);
        }
    }
}
