package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.interview.array.LongestPalindromicSubstring;
import org.jetbrains.annotations.NotNull;

public class LongestPalindromicSubstringUsingExpandOutApproachRevisedJava implements LongestPalindromicSubstring {

    @NotNull
    @Override
    public String longestPalindrome(@NotNull String s) {
        if (s.length() <= 1) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] odd = palindromeExpandingFromCenter(s, i, true);
            int[] even = palindromeExpandingFromCenter(s, i, false);
            int[] longer = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;
            if (longer[1] - longer[0] > end - start) {
                start = longer[0];
                end = longer[1];
            }
        }
        return s.substring(start, end + 1);
    }

    private int[] palindromeExpandingFromCenter(String s, int idx, boolean isOdd) {
        // odd palindrome: abxba
        // even palindrome: abxxba
        int l = idx;
        int r = isOdd ? idx : idx + 1 ;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[]{l + 1, r - 1};
    }
}
