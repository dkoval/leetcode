package com.github.dkoval.leetcode.challenge;

/**
 * You are given a string s of lowercase English letters and an integer array shifts of the same length.
 * <p>
 * Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 * <p>
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 * Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
 * <p>
 * Return the final string after all such shifts to s are applied.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of lowercase English letters</li>
 *  <li>shifts.length == s.length</li>
 *  <li>0 <= shifts[i] <= 10^9</li>
 * </ul>
 */
public class ShiftingLetters {

    private static final int MOD = 26;

    // O(N) time | O(1) extra space
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();

        int totalShifts = 0;
        for (int x : shifts) {
            totalShifts += x % MOD;
        }

        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            answer[i] = (char) ('a' + (index + totalShifts) % MOD);
            totalShifts -= shifts[i] % MOD;
        }
        return String.valueOf(answer);
    }
}
