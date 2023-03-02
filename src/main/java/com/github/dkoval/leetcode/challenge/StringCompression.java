package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/string-compression/">String Compression</a>
 * <p>
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * <ul>
 *  <li>If the group's length is 1, append the character to s.</li>
 *  <li>Otherwise, append the character followed by the group's length.</li>
 * </ul>
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the array.
 * <p>
 * You must write an algorithm that uses only constant extra space.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= chars.length <= 2000</li>
 *  <li>chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.</li>
 * </ul>
 */
public interface StringCompression {

    int compress(char[] chars);

    class StringCompressionRev1 implements StringCompression {

        @Override
        public int compress(char[] chars) {
            int n = chars.length;

            char c = chars[0];
            int count = 1;
            int writeIdx = 0;
            for (int i = 1; i < n; i++) {
                if (chars[i] == c) {
                    count++;
                } else {
                    writeIdx = writeGroup(chars, writeIdx, c, count);
                    c = chars[i];
                    count = 1;
                }
            }

            writeIdx = writeGroup(chars, writeIdx, c, count);
            return writeIdx;
        }

        private int writeGroup(char[] chars, int writeIdx, char c, int count) {
            chars[writeIdx++] = c;
            if (count > 1) {
                String s = String.valueOf(count);
                for (int i = 0; i < s.length(); i++) {
                    chars[writeIdx++] = s.charAt(i);
                }
            }
            return writeIdx;
        }
    }
}
