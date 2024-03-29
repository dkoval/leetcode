package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/break-a-palindrome/">Break a Palindrome</a>
 * <p>
 * Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase
 * English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
 * <p>
 * Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
 * <p>
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ,
 * a has a character strictly smaller than the corresponding character in b.
 * For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character,
 * and 'c' is smaller than 'd'.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= palindrome.length <= 1000</li>
 *  <li>palindrome consists of only lowercase English letters</li>
 * </ul>
 */
public interface BreakPalindrome {

    String breakPalindrome(String palindrome);

    // O(N) time | O(1) space
    class BreakPalindromeRev1 implements BreakPalindrome {

        @Override
        public String breakPalindrome(String palindrome) {
            int n = palindrome.length();
            if (n == 1) {
                return "";
            }

            int i = 0;
            int j = n - 1;
            while (i < j && palindrome.charAt(i) == 'a') {
                i++;
                j--;
            }

            return (i < j)
                    ? palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1)
                    : palindrome.substring(0, n - 1) + 'b';
        }
    }

    // O(N) time | O(1) space
    class BreakPalindromeRev2 implements BreakPalindrome {

        @Override
        public String breakPalindrome(String palindrome) {
            int n = palindrome.length();
            if (n == 1) {
                return "";
            }

            char[] s = palindrome.toCharArray();
            if (s[0] > 'a') {
                s[0] = 'a';
            } else {
                boolean done = false;
                for (int i = 1; i < n / 2; i++) {
                    if (s[i] > s[i - 1]) {
                        s[i] = 'a';
                        done = true;
                        break;
                    }
                }

                if (!done) {
                    s[n - 1] = s[n - 1] > 'a' ? 'a' : 'b';
                }
            }
            return String.valueOf(s);
        }
    }
}
