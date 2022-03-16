package com.github.dkoval.leetcode.challenge;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3653/">Validate Stack Sequences</a>
 * <p>
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been
 * the result of a sequence of push and pop operations on an initially empty stack.
 */
public class ValidateStackSequences {

    // O(N) time | O(N) space
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // pop() can only be done after at least one push() operation,
        // therefore, at each iteration, push the current item into the stack
        // and then keep on popping as many items as we can
        Stack<Integer> stack = new Stack<>();
        int i = 0; // index in popped[]
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && i < popped.length && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
