package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, new StringBuilder(), result);
        return result;
    }

    private void generateParenthesis(int numOpen, int numClose, StringBuilder prefix, List<String> result) {
        // base case
        if (numOpen == 0 && numClose == 0) {
            result.add(prefix.toString());
            return;
        }

        // include '(' if there are any
        if (numOpen > 0) {
            prefix.append('(');
            generateParenthesis(numOpen - 1, numClose, prefix, result);
            prefix.deleteCharAt(prefix.length() - 1); // backtrack
        }

        // include ')' IFF there is >= 1 '(' placed before
        if (numClose > numOpen) {
            prefix.append(')');
            generateParenthesis(numOpen, numClose - 1, prefix, result);
            prefix.deleteCharAt(prefix.length() - 1); // backtrack
        }
    }
}
