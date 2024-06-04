package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/longest-palindrome/">Longest Palindrome</a>
 * <p>
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome
 * that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 2000</li>
 *  <li>s consists of lowercase and/or uppercase English letters only</li>
 * </ul>
 */
public interface LongestPalindrome {

    int longestPalindrome(String s);

    class LongestPalindromeRev2 implements LongestPalindrome {

        @Override
        public int longestPalindrome(String s) {
            int n = s.length();

            int[] counts = new int[52];
            for (int i = 0; i < n; i++) {
                int index = indexOf(s.charAt(i));
                counts[index]++;
            }

            int ans = 0;
            boolean tookOdd = false;
            for (int x : counts) {
                ans += x;
                if (x % 2 != 0) {
                    if (tookOdd) {
                        ans--;
                    }
                    tookOdd = true;
                }
            }
            return ans;
        }

        private int indexOf(char c) {
            // lowercase letters
            if (c >= 'a' && c <= 'z') {
                return c - 'a';
            }
            // uppercase letters
            return c - 'A' + 26;
        }
    }

    class LongestPalindromeRev3 implements LongestPalindrome {

        @Override
        public int longestPalindrome(String s) {
            int n = s.length();

            int[] counts = new int[52];
            for (int i = 0; i < n; i++) {
                int index = indexOf(s.charAt(i));
                counts[index]++;
            }

            int ans = 0;
            int odds = 0;
            for (int x : counts) {
                ans += x;
                if (x % 2 != 0) {
                    odds++;
                }
            }
            return ans - (odds > 1 ? odds - 1 : 0);
        }

        private int indexOf(char c) {
            if (c >= 'a' && c <= 'z') {
                return c - 'a';
            }
            return c - 'A' + 26;
        }
    }
}
