package com.github.dkoval.leetcode.problems;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

public class WordBreakDPTopDownJava implements WordBreak {

    @Override
    public boolean wordBreak(@NotNull String s, @NotNull List<String> wordDict) {
        return doWordBreak(s, wordDict, new HashMap<>());
    }

    private boolean doWordBreak(String s, List<String> wordDict, HashMap<String, Boolean> memo) {
        if (wordDict.contains(s)) return true;
        Boolean alreadySolved = memo.get(s);
        if (alreadySolved != null) {
            return alreadySolved;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) && doWordBreak(s.substring(i), wordDict, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
