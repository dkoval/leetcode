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

    // O(N) time | O(N) space
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();

        int[] totalShifts = new int[n];
        totalShifts[n - 1] = shifts[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            totalShifts[i] = (totalShifts[i + 1] % MOD + shifts[i] % MOD) % MOD;
        }

        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            int shift = (s.charAt(i) - 'a' + totalShifts[i]) % MOD;
            answer[i] = (char) ('a' + shift);
        }
        return String.valueOf(answer);
    }
}
