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
        generateParenthesis(n, n, "", result);
        return result;
    }

    private void generateParenthesis(int numOpenParenthesis, int numClosedParenthesis, String prefix, List<String> result) {
        // base case
        if (numOpenParenthesis == 0 && numClosedParenthesis == 0) {
            result.add(prefix);
            return;
        }
        // try to include '('
        if (numOpenParenthesis > 0) {
            generateParenthesis(numOpenParenthesis - 1, numClosedParenthesis, prefix + "(", result);
        }
        // try to include ')'
        if (numOpenParenthesis < numClosedParenthesis) {
            generateParenthesis(numOpenParenthesis, numClosedParenthesis - 1, prefix + ")", result);
        }
    }
}
