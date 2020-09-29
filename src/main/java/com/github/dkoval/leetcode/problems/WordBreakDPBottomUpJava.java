package com.github.dkoval.leetcode.problems;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakDPBottomUpJava implements WordBreak {

    @Override
    public boolean wordBreak(@NotNull String s, @NotNull List<String> wordDict) {
        return doWordBreak(s, new HashSet<>(wordDict));
    }

    private boolean doWordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int dictWordMaxLength = dictWordMaxLength(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            int j = i - 1;
            while (j >= 0 && i - j <= dictWordMaxLength) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                j--;
            }
        }
        return dp[dp.length - 1];
    }

    private int dictWordMaxLength(Set<String> wordDict) {
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}
