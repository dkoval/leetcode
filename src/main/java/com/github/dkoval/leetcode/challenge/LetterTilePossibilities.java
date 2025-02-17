package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-tile-possibilities/">Letter Tile Possibilities</a>
 * <p>
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 * <p>
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= tiles.length <= 7</li>
 *  <li>tiles consists of uppercase English letters.</li>
 * </ul>
 */
public interface LetterTilePossibilities {

    int numTilePossibilities(String tiles);

    class LetterTilePossibilitiesRev1 implements LetterTilePossibilities {

        @Override
        public int numTilePossibilities(String tiles) {
            final var n = tiles.length();

            final var counts = new HashMap<Character, Integer>();
            for (var i = 0; i < n; i++) {
                final var c = tiles.charAt(i);
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            return backtrack(counts, n);
        }

        private int backtrack(Map<Character, Integer> counts, int remaining) {
            if (remaining == 0) {
                return 0;
            }

            var total = 0;
            for (var c : counts.keySet()) {
                if (counts.get(c) > 0) {
                    counts.put(c, counts.get(c) - 1);
                    total++; // each index we take yields a new sequence
                    total += backtrack(counts, remaining - 1);
                    counts.put(c, counts.get(c) + 1);
                }
            }
            return total;
        }
    }

    class LetterTilePossibilitiesRev2 implements LetterTilePossibilities {

        @Override
        public int numTilePossibilities(String tiles) {
            final var counts = new int[26];
            for (var i = 0; i < tiles.length(); i++) {
                counts[tiles.charAt(i) - 'A']++;
            }
            return backtrack(counts);
        }

        private int backtrack(int[] counts) {
            var total = 0;
            for (var i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    counts[i]--;
                    total++; // each index we take yields a new sequence
                    total += backtrack(counts);
                    // undo to try another character
                    counts[i]++;
                }
            }
            return total;
        }
    }
}
