package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/short-encoding-of-words/">Short Encoding of Words</a>
 * <p>
 * A valid encoding of an array of words is any reference string s and array of indices indices such that:
 * <ul>
 *  <li>words.length == indices.length</li>
 *  <li>The reference string s ends with the '#' character.</li>
 *  <li>For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].</li>
 * </ul>
 * Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 2000</li>
 *  <li>1 <= words[i].length <= 7</li>
 *  <li>words[i] consists of only lowercase letters</li>
 * </ul>
 */
public class ShortEncodingOfWords {

    public int minimumLengthEncoding(String[] words) {
        // Sort words[] by length in desc order
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());

        int minLength = 0;
        // Given a word, store all of its suffixes, e.g.
        // word = "time", suffixes = ["time", "ime", "me", "e"]
        Set<String> suffixes = new HashSet<>();
        for (String word : words) {
            if (!suffixes.contains(word)) {
                minLength += word.length() + 1; // +1 for '#' character
                for (int offset = 0; offset < word.length(); offset++) {
                    suffixes.add(word.substring(offset));
                }
            }
        }
        return minLength;
    }
}
