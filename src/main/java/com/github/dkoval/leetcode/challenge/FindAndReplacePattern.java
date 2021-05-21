package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3750/">Find and Replace Pattern</a>
 * <p>
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern.
 * You may return the answer in any order.
 * <p>
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x
 * in the pattern with p(x), we get the desired word.
 * <p>
 * Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
 * and no two letters map to the same letter.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= pattern.length <= 20</li>
 *  <li>1 <= words.length <= 50</li>
 *  <li>words[i].length == pattern.length</li>
 *  <li>pattern and words[i] are lowercase English letters</li>
 * </ul>
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (pattern.length() == 1) {
            return Arrays.asList(words);
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (match(pattern, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean match(String pattern, String word) {
        // every letter maps to another letter, and no two letters map to the same letter
        Map<Character, Character> directMapping = new HashMap<>();
        Map<Character, Character> reverseMapping = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            if (!directMapping.containsKey(p)) {
                if (reverseMapping.containsKey(w)) {
                    return false;
                }
                directMapping.put(p, w);
                reverseMapping.put(w, p);
            } else if (directMapping.get(p) != w) {
                return false;
            }
        }
        return true;
    }
}
