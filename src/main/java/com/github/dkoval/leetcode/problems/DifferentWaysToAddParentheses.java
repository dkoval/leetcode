package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">Different Ways to Add Parentheses</a>
 * <p>
 * Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
 * You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= expression.length <= 20</li>
 *  <li>expression consists of digits and the operator '+', '-', and '*'</li>
 *  <li>All the integer values in the input expression are in the range [0, 99]</li>
 * </ul>
 */
public interface DifferentWaysToAddParentheses {

    List<Integer> diffWaysToCompute(String expression);

    class DifferentWaysToAddParenthesesDivideAndConquer implements DifferentWaysToAddParentheses {

        @Override
        public List<Integer> diffWaysToCompute(String expression) {
            // divide and conquer expression[start : end] substring whenever we encounter an operator
            int n = expression.length();
            return doDiffWaysToCompute(expression, 0, n - 1);
        }

        private List<Integer> doDiffWaysToCompute(String expression, int start, int end) {
            List<Integer> ans = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                char c = expression.charAt(i);
                if (Character.isDigit(c)) {
                    continue;
                }

                List<Integer> xs = doDiffWaysToCompute(expression, start, i - 1);
                List<Integer> ys = doDiffWaysToCompute(expression, i + 1, end);

                for (int x : xs) {
                    for (int y : ys) {
                        if (c == '+') {
                            ans.add(x + y);
                        } else if (c == '-') {
                            ans.add(x - y);
                        } else if (c == '*') {
                            ans.add(x * y);
                        }
                    }
                }
            }

            if (ans.isEmpty()) {
                // expression is a number
                String s = expression.substring(start, end + 1);
                return Collections.singletonList(Integer.parseInt(s));
            }
            return ans;
        }
    }
}
