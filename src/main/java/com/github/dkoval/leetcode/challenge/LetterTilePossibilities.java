package com.github.dkoval.leetcode.challenge;

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
                    // use the character
                    total++;
                    counts[i]--;
                    total += backtrack(counts);
                    // undo to try another character
                    counts[i]++;
                }
            }
            return total;
        }
    }
}
