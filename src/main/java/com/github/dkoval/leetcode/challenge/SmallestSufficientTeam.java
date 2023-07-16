package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/smallest-sufficient-team/">Smallest Sufficient Team (Hard)</a>
 * <p>
 * In a project, you have a list of required skills req_skills, and a list of people. The ith person people[i] contains
 * a list of skills that the person has.
 * <p>
 * Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person
 * in the team who has that skill. We can represent these teams by the index of each person.
 * <p>
 * For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
 * Return any sufficient team of the smallest possible size, represented by the index of each person. You may return the answer in any order.
 * <p>
 * It is guaranteed an answer exists.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= req_skills.length <= 16</li>
 *  <li>1 <= req_skills[i].length <= 16</li>
 *  <li>req_skills[i] consists of lowercase English letters.</li>
 *  <li>All the strings of req_skills are unique.</li>
 *  <li>1 <= people.length <= 60</li>
 *  <li>0 <= people[i].length <= 16</li>
 *  <li>1 <= people[i][j].length <= 16</li>
 *  <li>people[i][j] consists of lowercase English letters.</li>
 *  <li>All the strings of people[i] are unique.</li>
 *  <li>Every skill in people[i] is a skill in req_skills.</li>
 *  <li>It is guaranteed a sufficient team exists.</li>
 * </ul>
 */
public interface SmallestSufficientTeam {

    int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people);

    class SmallestSufficientTeamRev1 implements SmallestSufficientTeam {

        @Override
        public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
            int n = reqSkills.length;
            int p = people.size();

            // Idea: DP top-down + bitmask to effectively represent the list of required skills
            // req_skills = ["java", "nodejs", "reactjs"]
            // index:        0,      1,        2
            // bitmask:      001,    010,      100
            Map<String, Integer> lookup = new HashMap<>();
            for (int i = 0; i < n; i++) {
                lookup.put(reqSkills[i], i);
            }

            // Now, represent the skills of the i-th person as a bitmask
            int[] peopleSkills = new int[p];
            for (int i = 0; i < p; i++) {
                for (String skill : people.get(i)) {
                    peopleSkills[i] |= 1 << lookup.get(skill);
                }
            }

            // The total number of combinations you can make out of N skills = 2^N
            // 00....0 (no skills)
            // 00....1
            // 00...10
            // 00...11
            // ...
            // 11...11 (all skills = 2^N - 1)
            int reqMask = (1 << n) - 1;

            // dp[i][mask]
            Team[][] dp = new Team[p][reqMask + 1];
            calculate(peopleSkills, reqMask, 0, 0, dp);

            List<Integer> team = new ArrayList<>();
            for (int i = 0, mask = 0; i < p && mask != reqMask; i++) {
                if (dp[i][mask] != null && dp[i][mask].expanded) {
                    team.add(i);
                    mask |= peopleSkills[i];
                }
            }

            int[] ans = new int[team.size()];
            for (int i = 0; i < team.size(); i++) {
                ans[i] = team.get(i);
            }
            return ans;
        }

        // Returns the size of the most sufficient team having all the required skills
        private int calculate(int[] peopleSkills, int reqMask, int i, int mask, Team[][] dp) {
            int p = peopleSkills.length;

            if (mask == reqMask) {
                return 0;
            }

            if (i >= p) {
                // 1 <= people.length <= 60
                return 10_000;
            }

            // already solved?
            if (dp[i][mask] != null) {
                return dp[i][mask].size;
            }

            // option #1: skip the i-th person
            int skip = calculate(peopleSkills, reqMask, i + 1, mask, dp);

            // option #2: take the i-th person
            int take = 1 + calculate(peopleSkills, reqMask, i + 1, mask | peopleSkills[i], dp);

            // cache and return the answer
            dp[i][mask] = new Team(Math.min(skip, take), take < skip);
            return dp[i][mask].size;
        }

        private static class Team {
            final int size;
            final boolean expanded;

            Team(int size, boolean expanded) {
                this.size = size;
                this.expanded = expanded;
            }
        }
    }
}
