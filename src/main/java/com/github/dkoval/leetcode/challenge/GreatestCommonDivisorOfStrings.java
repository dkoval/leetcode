package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">Greatest Common Divisor of Strings</a>
 * <p>
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= str1.length, str2.length <= 1000</li>
 *  <li>str1 and str2 consist of English uppercase letters.</li>
 * </ul>
 */
public interface GreatestCommonDivisorOfStrings {

    String gcdOfStrings(String str1, String str2);

    class GreatestCommonDivisorOfStringsRev1 implements GreatestCommonDivisorOfStrings {

        @Override
        public String gcdOfStrings(String str1, String str2) {
            int n1 = str1.length();
            int n2 = str2.length();

            // Brute force on prefix
            int k = Math.min(n1, n2);
            for (int len = k; len >= 1; len--) {
                if (k % len != 0) {
                    continue;
                }

                String prefix = str1.substring(0, len);
                if (repeats(str1, prefix) && repeats(str2, prefix)) {
                    return prefix;
                }
            }
            return "";
        }

        private boolean repeats(String s, String prefix) {
            int n = s.length();
            int p = prefix.length();

            if (n % p != 0) {
                return false;
            }

            for (int i = 0; i <= n - p; i += p) {
                if (!s.substring(i, i + p).equals(prefix)) {
                    return false;
                }
            }
            return true;
        }
    }
}
