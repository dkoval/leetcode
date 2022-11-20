package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/basic-calculator/">Basic Calculator</a>
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

        int ans = 0;
        int sign = 1;
        // The stack is used for storing `ans` and `sign` before starting the evaluation of an inner expression
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // check if there are more digits to the right of i
                int x = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    x *= 10;
                    x += s.charAt(i) - '0';
                    i++;
                }
                ans += x * sign;
                // prepare for the next iteration
                sign = 1;
                i--;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                // start evaluating an inner expression
                stack.push(ans);
                stack.push(sign);
                // from now on, `ans` variable will be accumulating the result of the last inner expression
                ans = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                // complete evaluating the last inner expression
                ans *= stack.pop(); // handle the sign of the inner expression, i.e. ± (expr)
                ans += stack.pop(); // add in the result computed so far
            }
            i++;
        }
        return ans;
    }
}
