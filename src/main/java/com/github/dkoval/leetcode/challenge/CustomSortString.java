package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3813/">Custom Sort String</a>
 * <p>
 * order and str are strings composed of lowercase letters. In order, no letter occurs more than once.
 * <p>
 * order was sorted in some custom order previously. We want to permute the characters of str so that they match
 * the order that order was sorted. More specifically, if x occurs before y in order,
 * then x should occur before y in the returned string.
 * <p>
 * Return any permutation of str (as a string) that satisfies this property.
 * <p>
 * Note:
 * <ul>
 *  <li>order has length at most 26, and no character is repeated in order.</li>
 *  <li>str has length at most 200.</li>
 *  <li>order and str consist of lowercase letters only.</li>
 * </ul>
 */
public class CustomSortString {

    public String customSortString(String order, String str) {
        int n = str.length();
        Character[] result = new Character[n];
        for (int i = 0; i < n; i++) {
            result[i] = str.charAt(i);
        }

        Map<Character, Integer> indices = index(order);
        Arrays.sort(result, Comparator.comparingInt(c -> indices.getOrDefault(c, 42))); // any number > 26

        StringBuilder sb = new StringBuilder();
        for (Character c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    private Map<Character, Integer> index(String str) {
        Map<Character, Integer> indices = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            indices.put(str.charAt(i), i);
        }
        return indices;
    }
}
