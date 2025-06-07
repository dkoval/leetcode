package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/">Lexicographically Minimum String After Removing Stars</a>
 * <p>
 * You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.
 * <p>
 * While there is a '*', do the following operation:
 * <p>
 * Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, you can delete any of them.
 * <p>
 * Return the lexicographically smallest resulting string after removing all '*' characters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists only of lowercase English letters and '*'.</li>
 *  <li>The input is generated such that it is possible to delete all '*' characters.</li>
 * </ul>
 */
public interface LexicographicallyMinimumStringAfterRemovingStars {

    String clearStars(String s);

    class LexicographicallyMinimumStringAfterRemovingStarsRev1 implements LexicographicallyMinimumStringAfterRemovingStars {

        @Override
        public String clearStars(String s) {
            final var n = s.length();

            // for each s[i], record the indices at which it occurs
            final var stacks = new ArrayList<Deque<Integer>>(26);
            for (var i = 0; i < 26; i++) {
                stacks.add(new ArrayDeque<>());
            }

            final var removed = new HashSet<Integer>();
            for (var i = 0; i < n; i++) {
                if (s.charAt(i) != '*') {
                    stacks.get(s.charAt(i) - 'a').push(i);
                    continue;
                }

                // remove the smallest non-* character to the left of current *
                for (var stack : stacks) {
                    if (!stack.isEmpty()) {
                        final var index = stack.pop();
                        removed.add(index);
                        break;
                    }
                }
            }

            // construct the final answer
            final var ans = new StringBuilder();
            for (var i = 0; i < n; i++) {
                final var c = s.charAt(i);
                if (c != '*' && !removed.contains(i)) {
                    ans.append(c);
                }
            }
            return ans.toString();
        }
    }
}
