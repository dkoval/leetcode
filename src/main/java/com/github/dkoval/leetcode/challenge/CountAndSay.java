package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-and-say/">Count and Say</a>
 * <p>
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <ul>
 *  <li>countAndSay(1) = "1"</li>
 *  <li>countAndSay(n) is the run-length encoding of countAndSay(n - 1).</li>
 * </ul>
 * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters
 * (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters
 * (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32",
 * replace "5" with "15" and replace "1" with "11". Thus, the compressed string becomes "23321511".
 * <p>
 * Given a positive integer n, return the nth element of the count-and-say sequence.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 */
public interface CountAndSay {

    String countAndSay(int n);

    class CountAndSayRev1 implements CountAndSay {

        @Override
        public String countAndSay(int n) {
            var curr = "1";
            while (--n > 0) {
                curr = encode(curr);
            }
            return curr;
        }

        private String encode(String s) {
            final var sb = new StringBuilder();
            var c = s.charAt(0);
            var count = 1;
            for (var i = 1; i < s.length(); i++) {
                if (c == s.charAt(i)) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    c = s.charAt(i);
                    count = 1;
                }
            }
            sb.append(count).append(c);
            return sb.toString();
        }
    }
}
