package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.interview.array.LongestPalindromicSubstring;
import org.jetbrains.annotations.NotNull;

public class LongestPalindromicSubstringExpandAroundCenterRevisedJava implements LongestPalindromicSubstring {

    @NotNull
    @Override
    public String longestPalindrome(@NotNull String s) {
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
