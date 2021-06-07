package com.github.dkoval.leetcode.interview.design;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/562/>Min Stack</a>
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <ul>
 *  <li>MinStack() initializes the stack object.</li>
 *  <li>void push(val) pushes the element val onto the stack.</li>
 *  <li>void pop() removes the element on the top of the stack.</li>
 *  <li>int top() gets the top element of the stack.</li>
 *  <li>int getMin() retrieves the minimum element in the stack.</li>
 * </ul>
 */
public class MinStack {

    private final Stack<Element> stack = new Stack<>();


    private static class Element {
        final int val;
        final int minVal;

        Element(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }

    public MinStack() {
        // noop
    }

    public void push(int val) {
        int minVal = stack.isEmpty() ? val : Math.min(val, stack.peek().minVal);
        stack.push(new Element(val, minVal));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minVal;
    }
}
