package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/capitalize-the-title/">Capitalize the Title</a>
 * <p>
 * You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters.
 * Capitalize the string by changing the capitalization of each word such that:
 * <ul>
 *  <li>If the length of the word is 1 or 2 letters, change all letters to lowercase.</li>
 *  <li>Otherwise, change the first letter to uppercase and the remaining letters to lowercase.</li>
 * </ul>
 * Return the capitalized title.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= title.length <= 100</li>
 *  <li>title consists of words separated by a single space without any leading or trailing spaces.</li>
 *  <li>Each word consists of uppercase and lowercase English letters and is non-empty.</li>
 * </ul>
 */
public interface CapitalizeTitle {

    String capitalizeTitle(String title);

    class CapitalizeTitleRev1 implements CapitalizeTitle {

        @Override
        public String capitalizeTitle(String title) {
            String[] words = title.split(" ");
            int n = words.length;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    sb.append(' ');
                }

                String word = words[i];
                int start = 0;
                if (word.length() > 2) {
                    sb.append(Character.toUpperCase(word.charAt(0)));
                    start = 1;
                }

                for (int k = start; k < word.length(); k++) {
                    sb.append(Character.toLowerCase(word.charAt(k)));
                }
            }
            return sb.toString();
        }
    }
}
