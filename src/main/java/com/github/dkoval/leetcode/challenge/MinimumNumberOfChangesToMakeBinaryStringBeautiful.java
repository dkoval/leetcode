package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/">Minimum Number of Changes to Make Binary String Beautiful</a>
 * <p>
 * You are given a 0-indexed binary string s having an even length.
 * <p>
 * A string is beautiful if it's possible to partition it into one or more substrings such that:
 * <ul>
 *  <li>Each substring has an even length.</li>
 *  <li>Each substring contains only 1's or only 0's.</li>
 * </ul>
 * You can change any character in s to 0 or 1.
 * <p>
 * Return the minimum number of changes required to make the string s beautiful.
 */
public interface MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    int minChanges(String s);

    class MinimumNumberOfChangesToMakeBinaryStringBeautifulRev1 implements MinimumNumberOfChangesToMakeBinaryStringBeautiful {

        @Override
        public int minChanges(String s) {
            int n = s.length();

            // Observation: we can create as many partitions as we want to make the given string beautiful.
            // The min even length of such a partition is 2.
            // 01, 10 -> 1 change, i.e. either change 0 -> 1 or 1 -> 0
            // 00, 11 -> 0 change
            int count = 0;
            for (int i = 0; i < n; i += 2) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    count++;
                }
            }
            return count;
        }
    }
}
