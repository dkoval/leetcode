package com.github.dkoval.leetcode.challenge;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3651/">Score of Parentheses</a>
 * <p>
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <ul>
 *  <li>() has score 1.</li>
 *  <li>AB has score A + B, where A and B are balanced parentheses strings.</li>
 *  <li>(A) has score 2 * A, where A is a balanced parentheses string.</li>
 * </ul>
 */
public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int score = 0;
                while (stack.peek() != 0) {
                    score += stack.pop();
                }
                // 2 cases to handle: () => 1, (A) => 2 * A
                score = Math.max(2 * score, 1);
                stack.pop();
                stack.push(score);
            }
        }

        int totalScore = 0;
        while (!stack.isEmpty()) {
            totalScore += stack.pop();
        }
        return totalScore;
    }
}
