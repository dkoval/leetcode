package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/baseball-game/">Baseball Game</a>
 * <p>
 * You are keeping score for a baseball game with strange rules. The game consists of several rounds,
 * where the scores of past rounds may affect future rounds' scores.
 * <p>
 * At the beginning of the game, you start with an empty record. You are given a list of strings ops,
 * where ops[i] is the ith operation you must apply to the record and is one of the following:
 * <ul>
 *  <li>An integer x - Record a new score of x.</li>
 *  <li>"+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.</li>
 *  <li>"D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.</li>
 *  <li>"C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.</li>
 * </ul>
 * <p>
 * Return the sum of all the scores on the record.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= ops.length <= 1000.</li>
 *  <li>ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 10^4, 3 * 10^4].</li>
 *  <li>For operation "+", there will always be at least two previous scores on the record.</li>
 *  <li>For operations "C" and "D", there will always be at least one previous score on the record.</li>
 * </ul>
 */
public class BaseballGame {

    // O(N) time | O(N) space
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : ops) {
            process(stack, s);
        }
        return sum(stack);
    }

    private void process(Deque<Integer> stack, String s) {
        if ("+".equals(s) || "D".equals(s) || "C".equals(s)) {
            acceptCommand(stack, s);
        } else {
            int x = Integer.parseInt(s);
            stack.push(x);
        }
    }

    private void acceptCommand(Deque<Integer> stack, String command) {
        switch (command) {
            case "+":
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x);
                stack.push(y);
                stack.push(x + y);
                break;
            case "D":
                int top = stack.peek();
                stack.push(2 * top);
                break;
            case "C":
                stack.pop();
                break;
            default:
                throw new IllegalArgumentException("Unsupported command: " + command);
        }
    }

    private int sum(Iterable<Integer> nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return sum;
    }
}
