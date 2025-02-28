package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/shortest-common-supersequence/">Shortest Common Supersequence (Hard)</a>
 * <p>
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
 * <p>
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= str1.length, str2.length <= 1000</li>
 *  <li>str1 and str2 consist of lowercase English letters</li>
 * </ul>
 */
public interface ShortestCommonSupersequence {

    String shortestCommonSupersequence(String s1, String s2);

    // O(N * M) time | O(N * M) space
    // Resource: https://youtu.be/_vAitge0VEQ?si=NvRfmJHhMtGS3__V
    class ShortestCommonSupersequenceRev1 implements ShortestCommonSupersequence {

        @Override
        public String shortestCommonSupersequence(String s1, String s2) {
            final var m = s1.length();
            final var n = s2.length();

            final var cache = new Integer[m][n];
            final var sb = new StringBuilder();

            var i = 0;
            var j = 0;
            while (i < m || j < n) {
                if (i == m) {
                    sb.append(s2.charAt(j));
                    j++;
                    continue;
                }

                if (j == n) {
                    sb.append(s1.charAt(i));
                    i++;
                    continue;
                }

                if (s1.charAt(i) == s2.charAt(j)) {
                    sb.append(s1.charAt(i));
                    i++;
                    j++;
                    continue;
                }

                if (dp(s1, s2, i + 1, j, cache) < dp(s1, s2, i, j + 1, cache)) {
                    sb.append(s1.charAt(i));
                    i++;
                } else {
                    sb.append(s2.charAt(j));
                    j++;
                }
            }

            return sb.toString();
        }

        // Returns the length of the shortest string having s1[i:] and s2[j:] as subsequences
        private int dp(String s1, String s2, int i, int j, Integer[][] cache) {
            // base cases
            if (i == s1.length()) {
                return s2.length() - j;
            }

            if (j == s2.length()) {
                return s1.length() - i;
            }

            // already solved?
            if (cache[i][j] != null) {
                return cache[i][j];
            }

            return cache[i][j] = (s1.charAt(i) == s2.charAt(j))
                    ? 1 + dp(s1, s2, i + 1, j + 1, cache)
                    : 1 + Math.min(dp(s1, s2, i + 1, j, cache), dp(s1, s2, i, j + 1, cache));
        }
    }
}
