package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/">Divide Players Into Teams of Equal Skill</a>
 * <p>
 * You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player.
 * Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.
 * <p>
 * The chemistry of a team is equal to the product of the skills of the players on that team.
 * <p>
 * Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams
 * such that the total skill of each team is equal.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= skill.length <= 10^5</li>
 *  <li>skill.length is even</li>
 *  <li>1 <= skill[i] <= 1000</li>
 * </ul>
 */
public interface DividePlayersIntoTeamsOfEqualSkill {

    long dividePlayers(int[] skill);

    class DividePlayersIntoTeamsOfEqualSkillRev1 implements DividePlayersIntoTeamsOfEqualSkill {

        @Override
        public long dividePlayers(int[] skill) {
            // n is even
            int n = skill.length;
            int numTeams = n / 2;

            int totalSkill = 0;
            Map<Integer, Integer> counts = new HashMap<>();
            for (int x : skill) {
                totalSkill += x;
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }

            if (totalSkill % numTeams != 0) {
                return -1;
            }

            int teamSkill = totalSkill / numTeams;

            long totalChemistry = 0;
            for (int x : counts.keySet()) {
                int y = teamSkill - x;

                if (!counts.containsKey(y)) {
                    return -1;
                }

                // for x and y to form a valid pair, their corresponding counts must be equal
                int count = counts.get(x);
                if (count != counts.get(y)) {
                    return -1;
                }

                // (x, y) and (y, x) represent the same valid pair.
                // When both counts are 0, this means that either
                // (x, y) or (y, x) has been processed at this stage.
                if (count == 0) {
                    continue;
                }

                long delta = (long) x * y * count;

                // mark x as processed
                counts.put(x, 0);

                if (x == y) {
                    delta /= 2;
                } else {
                    // mark y as processed
                    counts.put(y, 0);
                }

                totalChemistry += delta;
            }
            return totalChemistry;
        }
    }
}
