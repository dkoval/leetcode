package com.github.dkoval.leetcode.problems;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakDPTopDownJava implements WordBreak {

    @Override
    public boolean wordBreak(@NotNull String s, @NotNull List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        if (dict.contains(s)) {
            return true;
        }

        // memo[i] - whether suffix s[i:] can be broken down into words from `dict`
        Boolean[] memo = new Boolean[n];
        return doWordBreak(s, dict, 0, memo);
    }

    // whether suffix s[idx:] can be broken down into words from `wordDict`
    private boolean doWordBreak(String s, Set<String> wordDict, int idx, Boolean[] memo) {
        if (idx == s.length()) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int i = idx; i < s.length(); i++) {
            String word = s.substring(idx, i + 1);
            if (wordDict.contains(word) && doWordBreak(s, wordDict, i + 1, memo)) {
                return memo[idx] = true;
            }
        }
        return memo[idx] = false;
    }
}
