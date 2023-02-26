package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class EditDistanceDPTopDown implements EditDistance {

    @Override
    public int minDistance(@NotNull String word1, @NotNull String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        Integer[][] memo = new Integer[n1 + 1][n2 + 1];
        return solve(word1, n1 - 1, word2, n2 - 1, memo);
    }

    // Input: i = 0 .. N1, j = 0 .. N2
    // O(N1 * N2) time | O(N1 * N2) space
    private int solve(String source, int i, String target, int j, Integer[][] memo) {
        if (i < 0) {
            // insert (j + 1) chars at the end of source = "" to convert it to target[0 : j]
            return j + 1;
        }

        if (j < 0) {
            // delete (i + 1) chars from source[0 : i] to convert it to target = ""
            return i + 1;
        }

        // already solved?
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (source.charAt(i) == target.charAt(j)) {
            return solve(source, i - 1, target, j - 1, memo);
        }

        int best = Integer.MAX_VALUE;

        // replace the last char of `source` with the last char of `target`, then convert source[0 : i - 1] to target[0 : j - 1]
        best = Math.min(best, 1 + solve(source, i - 1, target, j - 1, memo));

        // delete the last char of `source`, then convert source[0 : i - 1] to target[0 : j]
        best = Math.min(best, 1 + solve(source, i - 1, target, j, memo));

        // insert the last char of `target` at the end of `source`, then convert source[0 : i] to target[0 : j - 1]
        best = Math.min(best, 1 + solve(source, i, target, j - 1, memo));

        // cache and return the answer
        return memo[i][j] = best;
    }
}
