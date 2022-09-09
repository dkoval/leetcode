package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/">The Number of Weak Characters in the Game</a>
 * <p>
 * You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense.
 * You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.
 * <p>
 * A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels.
 * More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.
 * <p>
 * Return the number of weak characters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= properties.length <= 10^5</li>
 *  <li>properties[i].length == 2</li>
 *  <li>1 <= attacki, defensei <= 10^5</li>
 * </ul>
 */
public interface NumberOfWeakCharactersInGame {

    int numberOfWeakCharacters(int[][] properties);

    class NumberOfWeakCharactersInGameTLE implements NumberOfWeakCharactersInGame {

        @Override
        public int numberOfWeakCharacters(int[][] properties) {
            // sort properties[] by attack value
            Arrays.sort(properties, Comparator.comparingInt(property -> property[0]));

            // group properties with the same attack value together:
            // attack -> defence values
            Map<Integer, List<Integer>> groups = new LinkedHashMap<>();
            for (int[] property : properties) {
                groups.computeIfAbsent(property[0], key -> new ArrayList<>()).add(property[1]);
            }

            // for an arbitrary i-th group, next groups always have a greater attack value, therefore
            // for each defence value in the current group, check if there exists a higher defence value present in the next groups
            int idx = 0;
            int[] attacks = new int[groups.size()];
            for (int attack : groups.keySet()) {
                attacks[idx++] = attack;
            }

            int count = 0;
            for (int i = 0; i < attacks.length - 1; i++) {
                List<Integer> currDefences = groups.get(attacks[i]);
                for (int currDefence : currDefences) {
                    boolean found = false;
                    for (int j = i + 1; j < attacks.length && !found; j++) {
                        List<Integer> nextDefences = groups.get(attacks[j]);
                        for (int nextDefence : nextDefences) {
                            if (nextDefence > currDefence) {
                                count++;
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }
            return count;
        }
    }

    class NumberOfWeakCharactersInGameUsingSorting implements NumberOfWeakCharactersInGame {

        @Override
        public int numberOfWeakCharacters(int[][] properties) {
            // sort properties[] by attack in DESC order, then by defence in ASC order
            Arrays.sort(properties, (x, y) -> (x[0] == y[0]) ? Integer.compare(x[1], y[1]) : -Integer.compare(x[0], y[0]));

            int count = 0;
            int maxDefenceSoFar = 0;
            for (int[] x : properties) {
                // because of sorting, x's attack value is smaller than attack values of previous characters,
                // therefore we only need to compare defence values here
                if (x[1] < maxDefenceSoFar) {
                    // there's a character seen before with both attack and defence values strictly greater than
                    // x's attack and defence values
                    count++;
                }
                maxDefenceSoFar = Math.max(maxDefenceSoFar, x[1]);
            }
            return count;
        }
    }
}
