package com.github.dkoval.leetcode.problems;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;

public class WordBreakDPBottomUpJava implements WordBreak {

    @Override
    public boolean wordBreak(@NotNull String s, @NotNull List<String> wordDict) {
        return doWordBreak(s, new HashSet<>(wordDict));
    }

    private boolean doWordBreak(String s, HashSet<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
