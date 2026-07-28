package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/smallest-palindromic-rearrangement-i/">Smallest Palindromic Rearrangement I</a>
 * <p>
 * You are given a palindromic string s.
 * <p>
 * Return the lexicographically smallest palindromic permutation of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of lowercase English letters.</li>
 *  <li>s is guaranteed to be palindromic.</li>
 * </ul>
 */
public interface SmallestPalindromicRearrangement1 {

    String smallestPalindrome(String s);

    class SmallestPalindromicRearrangement1Rev1 implements SmallestPalindromicRearrangement1 {

        @Override
        public String smallestPalindrome(String s) {
            final var n = s.length();

            if (n == 1) {
                return s;
            }

            final var half = new char[n / 2];
            for (var i = 0; i < half.length; i++) {
                half[i] = s.charAt(i);
            }

            Arrays.sort(half);

            final var sb = new StringBuilder();
            for (var i = 0; i < half.length; i++) {
                sb.append(half[i]);
            }

            var mid = new StringBuilder();
            if (n % 2 != 0) {
                mid.append(s.charAt(n / 2));
            }

            return sb.toString() + mid + sb.reverse();
        }
    }

    class SmallestPalindromicRearrangement1Rev2 implements SmallestPalindromicRearrangement1 {

        @Override
        public String smallestPalindrome(String s) {
            final var n = s.length();

            final var counts = new int[26];
            for (var i = 0; i < n; i++) {
                counts[s.charAt(i) - 'a']++;
            }

            final var half = new StringBuilder();
            final var mid = new StringBuilder();
            for (var i = 0; i < 26; i++) {
                final var c = (char) ('a' + i);
                half.repeat(c, counts[i] / 2);
                if (counts[i] % 2 != 0) {
                    mid.append(c);
                }
            }
            return half.toString() + mid + half.reverse();
        }
    }
}
