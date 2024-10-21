package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/">Split a String Into the Max Number of Unique Substrings</a>
 * <p>
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 * <p>
 * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string.
 * However, you must split the substrings such that all of them are unique.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 16</li>
 *  <li>s contains only lower case English letters.</li>
 * </ul>
 */
public interface SplitStringIntoMaxNumberOfUniqueSubstrings {

    int maxUniqueSplit(String s);

    class SplitStringIntoMaxNumberOfUniqueSubstringsRev1 implements SplitStringIntoMaxNumberOfUniqueSubstrings {

        @Override
        public int maxUniqueSplit(String s) {
            return calc(s, 0, new HashSet<>());
        }

        private int calc(String s, int start, Set<String> seen) {
            if (start == s.length()) {
                return 0;
            }

            // try every position to split s[start:]
            // ... xxxxx | yyyyyyyyy
            //     ^   ^   <-------> a new sub-problem
            //   start end
            int count = 0;
            for (int end = start; end < s.length(); end++) {
                String substr = s.substring(start, end + 1);
                if (seen.contains(substr)) {
                    continue;
                }
                // apply backtracking technique
                seen.add(substr);
                count = Math.max(count, 1 + calc(s, end + 1, seen));
                seen.remove(substr);
            }
            return count;
        }
    }
}
