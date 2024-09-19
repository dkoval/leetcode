package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

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

        private static final Map<Character, BiFunction<Integer, Integer, Integer>> OPS = Map.ofEntries(
                Map.entry('+', (x, y) -> x + y),
                Map.entry('-', (x, y) -> x - y),
                Map.entry('*', (x, y) -> x * y)
        );

        @Override
        public List<Integer> diffWaysToCompute(String expression) {
            int n = expression.length();
            // divide and conquer expression[left : right] substring whenever we encounter an operator
            return calc(expression, 0, n - 1);
        }

        private List<Integer> calc(String expression, int left, int right) {
            List<Integer> ans = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                char c = expression.charAt(i);
                if (Character.isDigit(c)) {
                    continue;
                }

                List<Integer> xs = calc(expression, left, i - 1);
                List<Integer> ys = calc(expression, i + 1, right);

                // xs * ys
                BiFunction<Integer, Integer, Integer> op = OPS.get(c);
                for (int x : xs) {
                    for (int y : ys) {
                        ans.add(op.apply(x, y));
                    }
                }
            }

            // base case
            if (ans.isEmpty()) {
                // expression[left : right] is a number
                String num = expression.substring(left, right + 1);
                ans.add(Integer.parseInt(num));
            }
            return ans;
        }
    }
}
