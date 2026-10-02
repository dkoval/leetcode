package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
public interface GenerateParentheses {

    List<String> generateParenthesis(int n);

    class GenerateParenthesesRev1 implements GenerateParentheses {

        @Override

        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            generate(n, n, new StringBuilder(), res);
            return res;
        }

        private void generate(int open, int close, StringBuilder current, List<String> res) {
            // base case
            if (open == 0 && close == 0) {
                res.add(current.toString());
                return;
            }

            // option 1: include '('
            if (open > 0) {
                current.append('(');
                generate(open - 1, close, current, res);
                current.deleteCharAt(current.length() - 1); // backtrack
            }

            // option 2: include ')' IFF there at least 1 '(' placed before
            if (close > open) {
                current.append(')');
                generate(open, close - 1, current, res);
                current.deleteCharAt(current.length() - 1); // backtrack
            }
        }
    }
}
