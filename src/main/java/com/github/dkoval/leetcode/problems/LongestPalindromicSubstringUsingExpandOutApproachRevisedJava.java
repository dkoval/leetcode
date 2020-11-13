package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.interview.array.LongestPalindromicSubstring;
import org.jetbrains.annotations.NotNull;

public class LongestPalindromicSubstringUsingExpandOutApproachRevisedJava implements LongestPalindromicSubstring {

    @NotNull
    @Override
    public String longestPalindrome(@NotNull String s) {
        int start = 0, end = 0;
        for (int i = 1; i < s.length(); i++) {
            // For an odd palindrome, like "abxba", center at the given index "x"
            int[] odd = palindromeExpandingFromCenter(s, i - 1, i + 1);
            // For an even palindrome, like "abxxba", center between the given index and the previous one "x|x"
            int[] even = palindromeExpandingFromCenter(s, i - 1, i);
            int[] longer = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;
            if (longer[1] - longer[0] > end - start) {
                start = longer[0];
                end = longer[1];
            }
        }
        return s.substring(start, end + 1);
    }

    private int[] palindromeExpandingFromCenter(String s, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < s.length()) {
            if (s.charAt(leftIdx) != s.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }
        return new int[]{leftIdx + 1, rightIdx - 1};
    }
}
