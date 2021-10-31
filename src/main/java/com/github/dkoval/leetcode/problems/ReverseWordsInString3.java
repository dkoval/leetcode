package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">Reverse Words in a String III</a>
 * <p>
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 5 * 10^4</li>
 *  <li>s contains printable ASCII characters</li>
 *  <li>s does not contain any leading or trailing spaces</li>
 *  <li>There is at least one word in s</li>
 *  <li>All the words in s are separated by a single space</li>
 * </ul>
 */
public class ReverseWordsInString3 {

    // O(N) time | O(N) extra space
    public String reverseWords(String s) {
        int n = s.length();
        int start = 0;
        int end = start;
        char[] chars = s.toCharArray();
        while (end < n) {
            while (end < n && chars[end] != ' ') {
                end++;
            }
            reverseWord(chars, start, end - 1);
            start = end + 1;
            end = start;
        }
        return String.valueOf(chars);
    }

    private void reverseWord(char[] chars, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
}
