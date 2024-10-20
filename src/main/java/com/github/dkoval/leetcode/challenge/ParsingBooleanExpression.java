package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/parsing-a-boolean-expression/">Parsing A Boolean Expression (Hard)</a>
 * <p>
 * A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
 * <ul>
 * <li>'t' that evaluates to true.</li>
 * <li>'f' that evaluates to false.</li>
 * <li>'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.</li>
 * <li>'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.</li>
 * <li>'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.</li>
 * </ul>
 * Given a string expression that represents a boolean expression, return the evaluation of that expression.
 * <p>
 * It is guaranteed that the given expression is valid and follows the given rules.
 */
public interface ParsingBooleanExpression {

    boolean parseBoolExpr(String expression);

    class ParsingBooleanExpressionRev1 implements ParsingBooleanExpression {
        private static final Set<Character> OPERATORS = Set.of('&', '|', '!');
        private static final Set<Character> IGNORE = Set.of('(', ',');

        @Override
        public boolean parseBoolExpr(String expression) {
            int n = expression.length();

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = expression.charAt(i);

                if (IGNORE.contains(c)) {
                    continue;
                }

                if (c != ')') {
                    stack.push(c);
                } else {
                    boolean seenTrue = false;
                    boolean seenFalse = false;

                    while (!OPERATORS.contains(stack.peek())) {
                        char x = stack.pop();
                        if (x == 't') {
                            seenTrue = true;
                        } else if (x == 'f') {
                            seenFalse = true;
                        }
                    }

                    char operator = stack.pop();

                    if (operator == '&') {
                        // logical AND
                        stack.push(seenFalse ? 'f' : 't');
                    } else if (operator == '|') {
                        // logical OR
                        stack.push(seenTrue ? 't' : 'f');
                    } else {
                        // logical NOT
                        stack.push(seenFalse ? 't' : 'f');
                    }
                }
            }
            return stack.peek() == 't';
        }
    }
}
