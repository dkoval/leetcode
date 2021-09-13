package com.github.dkoval.leetcode.challenge;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3971/">Basic Calculator</a>
 * <p>
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it,
 * and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 3 * 10^5</li>
 *  <li>s consists of digits, '+', '-', '(', ')', and ' '.</li>
 *  <li>s represents a valid expression.</li>
 *  <li>'+' is not used as a unary operation.</li>
 *  <li>'-' could be used as a unary operation but it has to be inside parentheses.</li>
 *  <li>There will be no two consecutive operators in the input.</li>
 *  <li>Every number and running calculation will fit in a signed 32-bit integer.</li>
 * </ul>
 */
public class BasicCalculator {

    // O(N) time | O(N) space
    public int calculate(String s) {
        int n = s.length();
        int x = 0;
        int sign = 1;
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                // check if there are more digits to the right of i
                while (i < n && Character.isDigit(s.charAt(i))) {
                    x *= 10;
                    x += s.charAt(i) - '0';
                    i++;
                }
                answer += x * sign;
                // prepare for the next iteration
                x = 0;
                sign = 1;
                i--;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                // start evaluating inner expression
                stack.push(answer);
                stack.push(sign);
                // prepare for the next iteration
                answer = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                // complete evaluating inner expression
                int storedSign = stack.pop();
                answer *= storedSign;
                int storedAnswer = stack.pop();
                answer += storedAnswer;
            }
            i++;
        }
        return answer;
    }
}
