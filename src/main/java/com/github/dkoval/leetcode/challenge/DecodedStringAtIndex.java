package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/decoded-string-at-index/">Decoded String at Index</a>
 * <p>
 * You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
 * <ul>
 *  <li>If the character read is a letter, that letter is written onto the tape.</li>
 *  <li>If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.</li>
 *  <li>Given an integer k, return the kth letter (1-indexed) in the decoded string.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= s.length <= 100</li>
 *  <li>s consists of lowercase English letters and digits 2 through 9.</li>
 *  <li>s starts with a letter.</li>
 *  <li>1 <= k <= 10^9</li>
 *  <li>It is guaranteed that k is less than or equal to the length of the decoded string.</li>
 *  <li>The decoded string is guaranteed to have less than 2^63 letters.</li>
 * </ul>
 */
public interface DecodedStringAtIndex {

    String decodeAtIndex(String s, int k);

    class DecodedStringAtIndexRev1 implements DecodedStringAtIndex {

        // Resource: https://www.youtube.com/watch?v=KmHiO_zykkE
        @Override
        public String decodeAtIndex(String s, int k) {
            int n = s.length();

            // generating the decoded string is space inefficient,
            // however we can still compute the length of decoded string
            long l = lengthOfDecodedString(s);

            // walk the encoded string s backwards and discard repeating blocks
            for (int i = n - 1; i >= 0; i--) {
                k %= l;
                char c = s.charAt(i);
                if (c >= '2' && c <= '9') {
                    l /= c - '0';
                } else {
                    // c is a letter
                    if (k == 0) {
                        return c + "";
                    }
                    // remove the current letter c from the end of the remaining decoded string
                    l--;
                }
            }
            return "";
        }

        private long lengthOfDecodedString(String s) {
            int n = s.length();

            // The decoded string is guaranteed to have less than 2^63 letters
            long l = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c >= '2' && c <= '9') {
                    l *= c - '0';
                } else {
                    l++;
                }
            }
            return l;
        }
    }
}
