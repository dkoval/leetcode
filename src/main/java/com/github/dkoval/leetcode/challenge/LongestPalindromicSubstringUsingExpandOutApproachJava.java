package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.interview.array.LongestPalindromicSubstring;
import org.jetbrains.annotations.NotNull;

public class LongestPalindromicSubstringUsingExpandOutApproachJava implements LongestPalindromicSubstring {

    @NotNull
    @Override
    public String longestPalindrome(@NotNull String s) {
        if (s.length() <= 1) return s;
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
