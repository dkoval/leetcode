package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/validate-stack-sequences/">Validate Stack Sequences</a>
 * <p>
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been
 * the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= pushed.length <= 1000</li>
 *  <li>0 <= pushed[i] <= 1000</li>
 *  <li>All the elements of pushed are unique.</li>
 *  <li>popped.length == pushed.length</li>
 *  <li>popped is a permutation of pushed.</li>
 * </ul>
 */
public interface ValidateStackSequences {

    boolean validateStackSequences(int[] pushed, int[] popped);

    // O(N) time | O(N) space
    class ValidateStackSequencesRev1 implements ValidateStackSequences {

        @Override
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int n = popped.length;

            // pop() can only be done after at least one push() operation,
            // therefore, at each iteration, push the current item into the stack
            // and then keep on popping as many items as we can
            Deque<Integer> stack = new ArrayDeque<>();
            int i = 0; // index in popped[]
            for (int x : pushed) {
                stack.push(x);
                while (!stack.isEmpty() && i < n && stack.peek() == popped[i]) {
                    stack.pop();
                    i++;
                }
            }
            return i == n;
        }
    }

    class ValidateStackSequencesRev2 implements ValidateStackSequences {

        @Override
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int n = pushed.length;

            Deque<Integer> stack = new ArrayDeque<>();
            int pushIdx = 0;
            int popIdx = 0;
            // push() and pop() if you can
            while (pushIdx < n) {
                if (!stack.isEmpty() && stack.peek() == popped[popIdx]) {
                    stack.pop();
                    popIdx++;
                } else {
                    stack.push(pushed[pushIdx]);
                    pushIdx++;
                }
            }
            // pop() if you can
            while (!stack.isEmpty() && popIdx < n && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            }
            return stack.isEmpty();
        }
    }
}
