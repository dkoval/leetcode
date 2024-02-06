package com.github.dkoval.leetcode.interview.array;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsJava implements GroupAnagrams {

    @NotNull
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            groups.computeIfAbsent(groupingKey(str), __ -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }

    private String groupingKey(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) {
                continue;
            }
            key.append('a' + i).append(counts[i]);
        }
        return key.toString();
    }
}
