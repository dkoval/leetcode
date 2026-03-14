package com.github.dkoval.leetcode.challenge;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/">The k-th Lexicographical String of All Happy Strings of Length n</a>
 * <p>
 * A happy string is a string that:
 * <p>
 * consists only of letters of the set ['a', 'b', 'c'].
 * <p>
 * s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
 * <p>
 * For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.
 * <p>
 * Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
 * <p>
 * Return the kth string of this list or return an empty string if there are less than k happy strings of length n.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10</li>
 *  <li>1 <= k <= 100</li>
 * </ul>
 */
public interface KthLexicographicalStringOfAllHappyStringsOfLengthN {

    String getHappyString(int n, int k);

    class KthLexicographicalStringOfAllHappyStringsOfLengthNRev1 implements KthLexicographicalStringOfAllHappyStringsOfLengthN {
        private int left = 0;
        private String ans = "";

        @Override
        public String getHappyString(int n, int k) {
            // keep on generating happy strings of length n until the k-th string is found
            backtrack(n, k, new StringBuilder());
            return ans;
        }

        private void backtrack(int n, int k, StringBuilder sb) {
            if (sb.length() == n) {
                if (left == k - 1) {
                    ans = sb.toString();
                }
                left++;
                return;
            }

            for (var c : List.of('a', 'b', 'c')) {
                if (sb.isEmpty() || c != sb.charAt(sb.length() - 1)) {
                    sb.append(c);
                    backtrack(n, k, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
