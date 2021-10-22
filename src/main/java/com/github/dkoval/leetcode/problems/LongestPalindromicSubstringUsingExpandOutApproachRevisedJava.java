package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.interview.array.LongestPalindromicSubstring;
import org.jetbrains.annotations.NotNull;

public class LongestPalindromicSubstringUsingExpandOutApproachRevisedJava implements LongestPalindromicSubstring {

    private static class Boundaries {
        final int start;
        final int end;

        static Boundaries takeLonger(Boundaries first, Boundaries second) {
            return (first.end - first.start) > (second.end - second.start) ? first : second;
        }

        Boundaries(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isLongerThat(Boundaries that) {
            return end - start > that.end - that.start;
        }
    }

    @NotNull
    @Override
    public String longestPalindrome(@NotNull String s) {
        int n = s.length();
        Boundaries ans = new Boundaries(0, 0);
        for (int i = 1; i < n; i++) {
            // For an odd palindrome, like "abxba", center is at the given index "x"
            Boundaries odd = expandFromCenter(s, i - 1, i + 1);
            // For an even palindrome, like "abxxba", center is between the given index and the previous one "x|x"
            Boundaries even = expandFromCenter(s, i - 1, i);

            Boundaries longer = Boundaries.takeLonger(odd, even);
            if (longer.isLongerThat(ans)) {
                ans = longer;
            }
        }
        return s.substring(ans.start, ans.end + 1);
    }

    private Boundaries expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new Boundaries(left + 1, right - 1);
    }
}
