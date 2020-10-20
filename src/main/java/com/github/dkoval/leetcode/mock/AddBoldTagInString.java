package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/add-bold-tag-in-string/">Add Bold Tag in String</a>
 * <p>
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag {@code <b>} and {@code </b>}
 * to wrap the substrings in s that exist in dict.
 * If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag.
 * Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 */
public class AddBoldTagInString {

    public String addBoldTag(String s, String[] dict) {
        int startInclusive = 0, endExclusive = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    endExclusive = Math.max(endExclusive, i + word.length());
                }
            }
            if (i == endExclusive) {
                sb.append("<b>").append(s, startInclusive, endExclusive).append("</b>");
            }
            if (i >= endExclusive) {
                sb.append(s.charAt(i));
                startInclusive = i + 1;
            }
        }
        if (endExclusive >= s.length()) {
            sb.append("<b>").append(s.substring(startInclusive)).append("</b>");
        }
        return sb.toString();
    }
}
