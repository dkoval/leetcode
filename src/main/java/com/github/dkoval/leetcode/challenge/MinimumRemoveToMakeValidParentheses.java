package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3645/">Minimum Remove to Make Valid Parentheses</a>
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <ul>
 *  <li>It is the empty string, contains only lowercase characters, or</li>
 *  <li>It can be written as AB (A concatenated with B), where A and B are valid strings, or</li>
 *  <li>It can be written as (A), where A is a valid string.</li>
 * </ul>
 */
public class MinimumRemoveToMakeValidParentheses {

    private final static char MARKER = '#';

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();

        // scan chars[] left-to-right to mark ')' chars that do not have a match
        matchParentheses(chars, true);
        // scan chars[] right-to-left to mark '(' chars that do not have a match
        matchParentheses(chars, false);

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != MARKER) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private void matchParentheses(char[] chars, boolean forward) {
        int i = forward ? 0 : chars.length - 1;
        final int end = forward ? chars.length : -1;
        final int step = forward ? 1 : -1;

        final char parenthesisToMatchWith = forward ? '(' : ')';
        final char matchingParenthesis = forward ? ')' : '(';

        int count = 0;
        while (i != end) {
            if (chars[i] == parenthesisToMatchWith) {
                count++;
            } else if (chars[i] == matchingParenthesis) {
                if (count > 0) {
                    count--;
                } else {
                    chars[i] = MARKER;
                }
            }
            i += step;
        }
    }
}
