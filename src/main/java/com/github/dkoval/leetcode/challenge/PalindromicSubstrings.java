package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3686/">Palindromic Substrings</a>
 * <p>
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 */
public class PalindromicSubstrings {

    // O(N^2) time | O(1) space
    public int countSubstrings(String s) {
        int count = 0;
        for (int mid = 0; mid < s.length(); mid++) {
            // odd-length palindrome: b a b
            // .........................^
            count += expandOut(s, mid, mid);

            // even-length palindrome: a a
            // .........................^
            count += expandOut(s, mid - 1, mid);
        }
        return count;
    }

    private int expandOut(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
