package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Reverse Words in a String</a>
 * <p>
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^4</li>
 *  <li>s contains English letters (upper-case and lower-case), digits, and spaces ' '.</li>
 *  <li>There is at least one word in s.</li>
 * </ul>
 */
public interface ReverseWordsInString {

    String reverseWords(String s);

    // O(N) time | O(N) space
    class ReverseWordsInStringJava implements ReverseWordsInString {

        @Override
        public String reverseWords(String s) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();

            int end = n - 1;
            while (end >= 0) {
                // skip trailing spaces
                while (end >= 0 && s.charAt(end) == ' ') {
                    end--;
                }

                if (end < 0) {
                    break;
                }

                // find the starting index of the current word
                int start = end;
                while (start >= 0 && s.charAt(start) != ' ') {
                    start--;
                }

                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(s, start + 1, end + 1);

                // prepare for the next iteration
                end = start;
            }
            return sb.toString();
        }
    }
}
