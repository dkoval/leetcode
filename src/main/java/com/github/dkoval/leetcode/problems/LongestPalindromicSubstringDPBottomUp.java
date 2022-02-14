package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.interview.array.LongestPalindromicSubstring;
import org.jetbrains.annotations.NotNull;

public class LongestPalindromicSubstringDPBottomUp implements LongestPalindromicSubstring {

    // Resource: https://iq.opengenus.org/longest-palindromic-substring-dp/
    // O(N^2) time | O(N^2) space
    @NotNull
    @Override
    public String longestPalindrome(@NotNull String s) {
        int n = s.length();

        // dp[i][j] denotes whether the substring from index i to j is a palindrome or not.
        // case #1: i = j      -> dp[i][i] = true, i.e. a single char is a palindrome of length 1
        // case #2: j - i = 1  -> dp[i][j] = (s[i] == s[i + 1]), i.e. two equal consecutive chars form a palindrome of length 2
        // case #3: j - i >= 2 -> dp[i][j] = dp[i + 1][j - 1] if s[i] == s[j]
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int end = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    // case #1
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) {
                        // case #2
                        dp[i][j] = true;
                    } else {
                        // case #3
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && (j - i > end - start)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
