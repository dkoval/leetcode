package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/">Number of Substrings Containing All Three Characters</a>
 * <p>
 * Given a string s consisting only of characters a, b and c.
 * <p>
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= s.length <= 5 * 10^4</li>
 *  <li>s only consists of a, b or c characters.</li>
 * </ul>
 */
public interface NumberOfSubstringsContainingAllThreeCharacters {

    int numberOfSubstrings(String s);

    class NumberOfSubstringsContainingAllThreeCharactersRev1 implements NumberOfSubstringsContainingAllThreeCharacters {

        @Override
        public int numberOfSubstrings(String s) {
            final var n = s.length();

            final var counts = new HashMap<Character, Integer>();
            var total = 0;
            var left = 0;
            for (var right = 0; right < n; right++) {
                final var rch = s.charAt(right);
                counts.put(rch, counts.getOrDefault(rch, 0) + 1);

                // shrink the window as much as possible
                while (counts.size() == 3) {
                    total += n - right;
                    final var lch = s.charAt(left);
                    final var count = counts.get(lch);
                    if (count > 1) {
                        counts.put(lch, count - 1);
                    } else {
                        counts.remove(lch);
                    }
                    left++;
                }
            }
            return total;
        }
    }

    class NumberOfSubstringsContainingAllThreeCharactersRev2 implements NumberOfSubstringsContainingAllThreeCharacters {

        @Override
        public int numberOfSubstrings(String s) {
            final var n = s.length();

            final var counts = new int[3];
            var total = 0;
            var left = 0;
            for (var right = 0; right < n; right++) {
                counts[s.charAt(right) - 'a']++;

                // shrink the window as much as possible
                while (isValidWindow(counts)) {
                    total += n - right;
                    counts[s.charAt(left) - 'a']--;
                    left++;
                }
            }
            return total;
        }

        private boolean isValidWindow(int[] counts) {
            for (var count : counts) {
                if (count == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
