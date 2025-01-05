package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/shifting-letters-ii/">Shifting Letters II</a>
 * <p>
 * You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni].
 * For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1,
 * or shift the characters backward if directioni = 0.
 * <p>
 * Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a').
 * Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').
 * <p>
 * Return the final string after all such shifts to s are applied.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length, shifts.length <= 5 * 10^4</li>
 *  <li>shifts[i].length == 3</li>
 *  <li>0 <= starti <= endi < s.length</li>
 *  <li>0 <= directioni <= 1</li>
 *  <li>s consists of lowercase English letters.</li>
 * </ul>
 */
public interface ShiftingLetters2 {

    String shiftingLetters(String s, int[][] shifts);

    // O(N) time | O(N) space
    class ShiftingLetters2Rev1 implements ShiftingLetters2 {

        @Override
        public String shiftingLetters(String s, int[][] shifts) {
            final var n = s.length();

            // idea: sweep line
            // difference array technique + prefix sum
            final var deltas = new int[n + 1];
            for (final var shift : shifts) {
                final var left = shift[0];
                final var right = shift[1];
                final var direction = (shift[2] == 0) ? -1 : 1;
                deltas[left] += direction;
                deltas[right + 1] -= direction;
            }

            final var sb = new StringBuilder();
            var total = 0; // prefix sum of deltas
            for (var i = 0; i < n; i++) {
                total += deltas[i];
                var c = s.charAt(i) - 'a';
                c += total;
                c %= 26;
                if (c < 0) {
                    c += 26;
                }
                sb.append((char) (c + 'a'));
            }
            return sb.toString();
        }
    }
}
