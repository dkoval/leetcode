package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.interview.array.LongestPalindromicSubstring;
import org.jetbrains.annotations.NotNull;

public class LongestPalindromicSubstringUsingExpandOutApproachRevisedJava implements LongestPalindromicSubstring {

    @NotNull
    @Override
    public String longestPalindrome(@NotNull String s) {
        if (s.length() <= 1) return s;
        int start = 0, end = 0;
        for (int i = 1; i < s.length(); i++) {
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
        // For an odd palindrome, like "abxba", center at the given index "x"
        // For an even palindrome, like "abxxba", center between the given index and the next one "x|x"
        int l = idx;
        int r = isOdd ? idx : idx + 1 ;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[]{l + 1, r - 1};
    }
}
