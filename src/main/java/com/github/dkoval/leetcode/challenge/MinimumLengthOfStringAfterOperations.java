package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-length-of-string-after-operations/">Minimum Length of String After Operations</a>
 * <p>
 * You are given a string s.
 * <p>
 * You can perform the following process on s any number of times:
 * <ul>
 *  <li>Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i],
 *  and at least one character to the right that is also equal to s[i].
 *  </li>
 *  <li>Delete the closest character to the left of index i that is equal to s[i].</li>
 *  <li>Delete the closest character to the right of index i that is equal to s[i].</li>
 * </ul>
 * Return the minimum length of the final string s that you can achieve.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 2 * 10^5</li>
 *  <li>s consists only of lowercase English letters.</li>
 * </ul>
 */
public interface MinimumLengthOfStringAfterOperations {

    int minimumLength(String s);

    // O(N) time | O(1) space
    class MinimumLengthOfStringAfterOperationsRev1 implements MinimumLengthOfStringAfterOperations {

        @Override
        public int minimumLength(String s) {
            final var n = s.length();

            final var counts = new int[26];
            for (var i = 0; i < n; i++) {
                counts[s.charAt(i) - 'a']++;
            }

            var ans = 0;
            for (var count : counts) {
                if (count < 3) {
                    ans += count;
                } else {
                    ans += (count % 2 == 0) ? 2 : 1;
                }
            }
            return ans;
        }
    }
}
