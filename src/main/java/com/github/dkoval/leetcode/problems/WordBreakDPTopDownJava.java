package com.github.dkoval.leetcode.problems;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WordBreakDPTopDownJava implements WordBreak {

    @Override
    public boolean wordBreak(@NotNull String s, @NotNull List<String> wordDict) {
        return doWordBreak(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private boolean doWordBreak(String s, Set<String> wordDict, Map<String, Boolean> memo) {
        if (wordDict.contains(s)) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        // check all possible prefixes s[0:i]
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1)) && doWordBreak(s.substring(i + 1), wordDict, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
