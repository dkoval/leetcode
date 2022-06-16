package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>s consist of only digits and English letters</li>
 * </ul>
 */
public interface LongestPalindromicSubstring {

    String longestPalindrome(String s);

    class LongestPalindromicSubstringExpandAroundCenterRev1 implements LongestPalindromicSubstring {

        @Override
        public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }

            int startIndex = 0;
            int endIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                int lengthOdd = lengthOfPalindromeExpandingFromCenter(s, i, true);
                int lengthEven = lengthOfPalindromeExpandingFromCenter(s, i, false);
                int length = Math.max(lengthOdd, lengthEven);
                if (length > endIndex - startIndex + 1) {
                    startIndex = i - (length - 1) / 2;
                    endIndex = i + length / 2;
                }
            }
            return s.substring(startIndex, endIndex + 1);
        }

        private int lengthOfPalindromeExpandingFromCenter(String s, int index, boolean isOdd) {
            int l = index;
            int r = isOdd ? index : index + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            // after loop is executed: ..., l, start, ..., end, r, ...
            // therefore length of s.substring(start..end) = end - start + 1 = end - l = r - 1 - l
            return r - l - 1;
        }
    }

    class LongestPalindromicSubstringExpandAroundCenterRev2 implements LongestPalindromicSubstring {

        @Override
        public String longestPalindrome(String s) {
            int n = s.length();
            // best[] stores starting and ending indices of the longest palindrome
            int[] best = {0, 0};
            for (int i = 1; i < n; i++) {
                // for an odd palindrome, like "abxba", center is at the given index "x"
                int[] odd = expandAroundCenter(s, i - 1, i + 1);
                // for an even palindrome, like "abxxba", center is between the given index and the previous one "x|x"
                int[] even = expandAroundCenter(s, i - 1, i);

                // compare lengths of computed palindromes to select the best option
                if (odd[1] - odd[0] + 1 > best[1] - best[0] + 1) {
                    best = odd;
                }

                if (even[1] - even[0] + 1 > best[1] - best[0] + 1) {
                    best = even;
                }
            }
            return s.substring(best[0], best[1] + 1);
        }

        private int[] expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return new int[]{left + 1, right - 1};
        }
    }

    class LongestPalindromicSubstringDPBottomUp implements LongestPalindromicSubstring {

        // Resource: https://iq.opengenus.org/longest-palindromic-substring-dp/
        // O(N^2) time | O(N^2) space
        @Override
        public String longestPalindrome(String s) {
            int n = s.length();

            // dp[i][j] denotes whether the substring from index i to j is a palindrome or not.
            // case #1: i = j      -> dp[i][i] = true, i.e. a single char is a palindrome of length 1
            // case #2: j - i = 1  -> dp[i][j] = (s[i] == s[i + 1]), i.e. two equal consecutive chars form a palindrome of length 2
            // case #3: j - i >= 2 -> dp[i][j] = dp[i + 1][j - 1] if s[i] == s[j]
            boolean[][] dp = new boolean[n][n];

            int start = 0;
            int end = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        // case #1
                        dp[i][j] = true;
                    } else if (s.charAt(i) == s.charAt(j)) {
                        if (j == i + 1) {
                            // case #2
                            dp[i][j] = true;
                        } else {
                            // case #3
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    if (dp[i][j] && (j - i > end - start)) {
                        start = i;
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }
}
