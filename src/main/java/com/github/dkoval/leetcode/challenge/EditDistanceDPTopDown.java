package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class EditDistanceDPTopDown implements EditDistance {

    @Override
    public int minDistance(@NotNull String source, @NotNull String target) {
        int m = source.length();
        int n = target.length();
        Integer[][] memo = new Integer[m + 1][n + 1];
        return doMinDistance(source, m - 1, target, n - 1, memo);
    }

    // Input: i = 0..M, j = 0..N
    // O(M * N) time | O(M * N) space
    private int doMinDistance(String source, int i, String target, int j, Integer[][] memo) {
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
            return doMinDistance(source, i - 1, target, j - 1, memo);
        }

        int best = Integer.MAX_VALUE;

        // delete the last char in source, then convert source[0 : i - 1] to target
        best = Math.min(best, 1 + doMinDistance(source, i - 1, target, j, memo));

        // replace the last char in source with last char in target, then convert source[0 : i - 1] to target[0 : j - 1]
        best = Math.min(best, 1 + doMinDistance(source, i - 1, target, j - 1, memo));

        // insert the last char in target at the end of source, then convert source[0 : i] to target[0 : j - 1]
        best = Math.min(best, 1 + doMinDistance(source, i, target, j - 1, memo));

        // cache and return the answer
        return memo[i][j] = best;
    }
}
