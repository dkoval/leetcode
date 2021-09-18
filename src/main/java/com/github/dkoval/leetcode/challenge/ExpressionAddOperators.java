package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3979/">           (Hard)</a>
 * <p>
 * Given a string num that contains only digits and an integer target, return all possibilities
 * to add the binary operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates
 * to the target value.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= num.length <= 10</li>
 *  <li>num consists of only digits</li>
 *  <li>-2^31 <= target <= 2^31 - 1</li>
 * </ul>
 */
public class ExpressionAddOperators {

    // (N * 4^N) time | O(N) space
    public List<String> addOperators(String num, int target) {
        List<String> answer = new ArrayList<>();
        dfs(num, target, 0, "", 0, 0, answer);
        return answer;
    }

    private void dfs(String num, int target, int idx, String expr, long prevEval, long currEval, List<String> answer) {
        if (idx == num.length() && currEval == target) {
            answer.add(expr);
            return;
        }

        // take [idx:i] digits to form a number and then move on to the next sub-problem
        for (int i = idx; i < num.length(); i++) {
            String s = num.substring(idx, i + 1);
            long x = Long.parseLong(s);
            if (expr.isEmpty()) {
                // add the very 1st number to the expression and move on
                dfs(num, target, i + 1, s, currEval, currEval + x, answer);
            } else {
                dfs(num, target, i + 1, expr + "+" + s, currEval, currEval + x, answer);
                dfs(num, target, i + 1, expr + "-" + s, currEval, currEval - x, answer);
                // Suppose we want to multiply expr = 4 + 3 by x = 2. The multiply operator has a higher precedence,
                // hence 4 + 3 * 2 = 10. However, the expression gets evaluated like (4 + 3) * 2 = 14,
                // which is obviously wrong. Therefore, to fix the math, we keep track of previous and current evaluations.
                // At the time we get to (...) * 2 step, prevEval = 4, currEval = 4 + 3 = 7, x = 2.
                // To correct evaluation of the current expression, use the formula:
                // prevEval + (currEval - prevEval) * x = 4 + (7 - 4) * 2 = 10.
                // Note that instead of prevEval we could have kept track of the previous number.
                // In this case the formula would change to:
                // currEval - prevNum +  prevNum * x = 7 - 3 + 3 * 2 = 4 + 3 * 2 = 10.
                // Update prevNum to prevNum * x to proceed to the next iteration.
                dfs(num, target, i + 1, expr + "*" + s, prevEval, prevEval + (currEval - prevEval) * x, answer);
            }

            // ignore numbers with leading 0s, i.e.
            // "0" is valid, whereas "0*" are wrong
            if (num.charAt(idx) == '0') {
                break;
            }
        }
    }
}
