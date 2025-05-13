package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/total-characters-in-string-after-transformations-i/">Total Characters in String After Transformations I</a>
 * <p>
 * You are given a string s and an integer t, representing the number of transformations to perform.
 * In one transformation, every character in s is replaced according to the following rules:
 * <ul>
 *  <li>If the character is 'z', replace it with the string "ab".</li>
 *  <li>Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.</li>
 * </ul>
 * Return the length of the resulting string after exactly t transformations.
 * <p>
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists only of lowercase English letters.</li>
 *  <li>1 <= t <= 10^5</li>
 * </ul>
 */
public interface TotalCharactersInStringAfterTransformations1 {

    int MOD = 1_000_000_007;

    int lengthAfterTransformations(String s, int t);

    class TotalCharactersInStringAfterTransformations1Rev1 implements TotalCharactersInStringAfterTransformations1 {

        @Override
        public int lengthAfterTransformations(String s, int t) {
            final var n = s.length();

            var counts = new int[26];
            for (var i = 0; i < n; i++) {
                counts[s.charAt(i) - 'a']++;
            }

            while (t-- > 0) {
                final var newCounts = new int[26];
                for (var i = 0; i < 26; i++) {
                    // replace each character with the next character in the alphabet
                    newCounts[(i + 1) % 26] += counts[i];
                    newCounts[(i + 1) % 26] %= MOD;
                    // z -> ab, whereas, at this stage, a is already handled
                    if (i == 25) {
                        newCounts[1] += counts[25];
                        newCounts[1] %= MOD;
                    }
                }
                counts = newCounts;
            }

            var total = 0;
            for (var count : counts) {
                total += count;
                total %= MOD;
            }
            return total;
        }
    }
}
