package com.github.dkoval.leetcode.problems;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Implement Queue using Stacks</a>
 * <p>
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * <ul>
 *  <li>void push(int x) Pushes element x to the back of the queue.</li>
 *  <li>int pop() Removes the element from the front of the queue and returns it.</li>
 *  <li>int peek() Returns the element at the front of the queue.</li>
 *  <li>boolean empty() Returns true if the queue is empty, false otherwise.</li>
 * </ul>
 * Notes:
 * <ul>
 *  <li>You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.</li>
 *  <li>Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.</li>
 * </ul>
 */
public abstract class ImplementQueueUsingStacks {

    public static class MyQueue {
        private final Stack<Integer> front = new Stack<>();
        private final Stack<Integer> back = new Stack<>();

        public MyQueue() {
            // nothing to do
        }

        public void push(int x) {
            back.push(x);
        }

        public int pop() {
            int first = peek();
            front.pop();
            return first;
        }

        public int peek() {
            if (!front.isEmpty()) {
                return front.peek();
            }

            while (!back.isEmpty()) {
                front.push(back.pop());
            }

            return front.peek();
        }

        public boolean empty() {
            return front.isEmpty() && back.isEmpty();
        }
    }
}
