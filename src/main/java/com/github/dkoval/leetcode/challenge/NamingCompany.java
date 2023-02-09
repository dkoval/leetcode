package com.github.dkoval.leetcode.challenge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/naming-a-company/">Naming a Company (Hard)</a>
 * <p>
 * You are given an array of strings ideas that represents a list of names to be used in the process of naming a company.
 * The process of naming a company is as follows:
 * <p>
 * Choose 2 distinct names from ideas, call them ideaA and ideaB.
 * Swap the first letters of ideaA and ideaB with each other.
 * If both of the new names are not found in the original ideas, then the name ideaA ideaB
 * (the concatenation of ideaA and ideaB, separated by a space) is a valid company name.
 * <p>
 * Otherwise, it is not a valid name.
 * Return the number of distinct valid names for the company.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= ideas.length <= 5 * 10^4</li>
 *  <li>1 <= ideas[i].length <= 10</li>
 *  <li>ideas[i] consists of lowercase English letters.</li>
 *  <li>All the strings in ideas are unique.</li>
 * </ul>
 */
public interface NamingCompany {

    long distinctNames(String[] ideas);

    // O(N^2 * L), where L is the average length of ideas[i]
    class NamingCompanyTLE implements NamingCompany {
        @Override
        public long distinctNames(String[] ideas) {
            int n = ideas.length;
            Set<String> dict = Arrays.stream(ideas).collect(Collectors.toSet());

            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    String s1 = ideas[j].charAt(0) + ideas[i].substring(1);
                    String s2 = ideas[i].charAt(0) + ideas[j].substring(1);

                    if (!dict.contains(s1) && !dict.contains(s2)) {
                        count += 2;
                    }
                }
            }
            return count;
        }
    }

    // Resource: https://www.youtube.com/watch?v=NrHpgTScOcY
    class NamingCompanyRev1 implements NamingCompany {

        // O(N * 26^2) time | O(N) space
        @Override
        public long distinctNames(String[] ideas) {
            // For any arbitrary pair of ideas[i], ideas[j], where i != j,
            // we can't obtain a valid name for the company if
            // - both ideas[i] and ideas[j] start with the same character
            // - suffixes ideas[i][1:] and ideas[j][1:] are the same

            // Step #1: group ideas by their first character.
            // There will be <= 26 groups (ideas[i] consists of lowercase English letters).
            Map<Character, Set<String>> groups = new HashMap<>();
            for (String idea : ideas) {
                groups.computeIfAbsent(idea.charAt(0), __ -> new HashSet<>()).add(idea.substring(1));
            }

            // Step #2: iterate through pairs of groups.
            long count = 0;
            List<Character> keys = new ArrayList<>(groups.keySet());
            for (int i = 0; i < keys.size() - 1; i++) {
                for (int j = i + 1; j < keys.size(); j++) {
                    // among ideas in groups[i] and groups[j], only consider those having distinct suffixes
                    Set<String> group1 = groups.get(keys.get(i));
                    Set<String> group2 = groups.get(keys.get(j));

                    // count repeatable suffixes
                    long common = 0;
                    for (String idea : group1) {
                        if (group2.contains(idea)) {
                            common++;
                        }
                    }

                    count += (group1.size() - common) * (group2.size() - common) * 2;
                }
            }
            return count;
        }
    }
}
