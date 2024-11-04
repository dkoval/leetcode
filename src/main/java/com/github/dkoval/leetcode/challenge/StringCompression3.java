package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/string-compression-iii/">String Compression III</a>
 * <p>
 * Given a string word, compress it using the following algorithm:
 * <p>
 * Begin with an empty string comp. While word is not empty, use the following operation:
 * <ul>
 *  <li>Remove a maximum length prefix of word made of a single character c repeating at most 9 times.</li>
 *  <li>Append the length of the prefix followed by c to comp.</li>
 * </ul>
 * Return the string comp.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word.length <= 2 * 10^5</li>
 *  <li>word consists only of lowercase English letters</li>
 * </ul>
 */
public interface StringCompression3 {

    String compressedString(String word);

    // O(N) time | O(1) extra space
    class StringCompression3Rev1 implements StringCompression3 {

        @Override
        public String compressedString(String word) {
            int n = word.length();

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < n) {
                char c = word.charAt(i);
                int count = 1;
                while (i + 1 < n && word.charAt(i + 1) == c && count < 9) {
                    i++;
                    count++;
                }
                sb.append(count).append(c);
                i++;
            }
            return sb.toString();
        }
    }
}
