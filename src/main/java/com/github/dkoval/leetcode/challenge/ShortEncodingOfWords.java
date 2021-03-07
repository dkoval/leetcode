package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3662/">Short Encoding of Words</a>
 * <p>
 * A valid encoding of an array of words is any reference string s and array of indices indices such that:
 * <ul>
 *  <li>words.length == indices.length</li>
 *  <li>The reference string s ends with the '#' character.</li>
 *  <li>For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].</li>
 * </ul>
 * Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
 */
public class ShortEncodingOfWords {

    public int minimumLengthEncoding(String[] words) {
        // Sort words[] by length in desc order
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        int answer = 0;
        // Given a word, stores all of its prefixes, e.g.
        // word = "time", prefixes = ["time", "ime", "me", "e"]
        Set<String> prefixes = new HashSet<>();
        for (String word : words) {
            if (!prefixes.contains(word)) {
                answer += word.length() + 1; // +1 for '#' character
                for (int i = 0; i < word.length(); i++) {
                    prefixes.add(word.substring(i));
                }
            }
        }
        return answer;
    }
}
