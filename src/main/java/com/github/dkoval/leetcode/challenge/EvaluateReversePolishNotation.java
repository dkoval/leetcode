package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3755/">Evaluate Reverse Polish Notation</a>
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to
 * a result, and there will not be any division by zero operation.
 */
public class EvaluateReversePolishNotation {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();

    static {
        operations.put("+", (x, y) -> x + y);
        operations.put("-", (x, y) -> x - y);
        operations.put("*", (x, y) -> x * y);
        operations.put("/", (x, y) -> x / y);
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (String token : tokens) {
            if (isOperator(token)) {
                int y = stack.pop();
                int x = stack.pop();
                result = evaluate(token, x, y);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? result : stack.pop();
    }

    private boolean isOperator(String token) {
        return operations.containsKey(token);
    }

    private int evaluate(String operator, int x, int y) {
        return operations.get(operator).apply(x, y);
    }
}
