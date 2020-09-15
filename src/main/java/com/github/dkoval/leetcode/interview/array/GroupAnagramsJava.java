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
            String key = keyOf(str);
            List<String> group = groups.computeIfAbsent(key, k -> new ArrayList<>());
            group.add(str);
        }
        return new ArrayList<>(groups.values());
    }

    private String keyOf(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            key.append('a' + i).append(counts[i]);
        }
        return key.toString();
    }
}
