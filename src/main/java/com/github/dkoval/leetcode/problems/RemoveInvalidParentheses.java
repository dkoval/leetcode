package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * <a href="https://leetcode.com/problems/remove-invalid-parentheses/">Remove Invalid Parentheses</a>
 * <p>
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 * <p>
 * Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 25</li>
 *  <li>s consists of lowercase English letters and parentheses '(' and ')'.</li>
 *  <li>There will be at most 20 parentheses in s.</li>
 * </ul>
 */
public interface RemoveInvalidParentheses {

    List<String> removeInvalidParentheses(String s);

    class RemoveInvalidParenthesesRev1 implements RemoveInvalidParentheses {

        private static final Set<Character> PARENTHESES = Set.of('(', ')');

        @Override
        public List<String> removeInvalidParentheses(String s) {
            // generate all possible valid placements of parentheses
            final var res = new HashSet<String>();
            generate(s, 0, "", 0, res);

            // take valid with the minimum number of removals
            final var maxLength = maxLengthOf(res);
            return takeOnly(res, it -> it.length() == maxLength);
        }

        private void generate(String s, int index, String current, int depth, Set<String> res) {
            if (depth < 0) {
                return;
            }

            // base case
            if (index == s.length()) {
                if (depth == 0) {
                    res.add(current);
                }
                return;
            }

            final var c = s.charAt(index);
            if (!PARENTHESES.contains(c)) {
                // take a letter
                generate(s, index + 1, current + c, depth, res);
            } else {
                // option 1: take
                final var delta = (c == '(') ? 1 : -1;
                generate(s, index + 1, current + c, depth + delta, res);

                // option 2: skip
                generate(s, index + 1, current, depth, res);
            }
        }

        private int maxLengthOf(Iterable<String> items) {
            var best = 0;
            for (var item : items) {
                best = Math.max(best, item.length());
            }
            return best;
        }

        private List<String> takeOnly(Iterable<String> items, Predicate<String> condition) {
            final var res = new ArrayList<String>();
            for (var item : items) {
                if (condition.test(item)) {
                    res.add(item);
                }
            }
            return res;
        }
    }
}
