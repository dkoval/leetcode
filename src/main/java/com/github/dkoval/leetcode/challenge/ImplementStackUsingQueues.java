package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/implement-stack-using-queues/">Implement Stack using Queues</a>
 * <p>
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * <p>
 * Implement the MyStack class:
 * <ul>
 *  <li>void push(int x) Pushes element x to the top of the stack.</li>
 *  <li>int pop() Removes the element on the top of the stack and returns it.</li>
 *  <li>int top() Returns the element on the top of the stack.</li>
 *  <li>boolean empty() Returns true if the stack is empty, false otherwise.</li>
 * </ul>
 * Notes:
 * <ul>
 *  <li>You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.</li>
 *  <li>Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= x <= 9</li>
 *  <li>At most 100 calls will be made to push, pop, top, and empty.</li>
 *  <li>All the calls to pop and top are valid.</li>
 * </ul>
 * <p>
 * Follow-up: Can you implement the stack using only one queue?
 */
public interface ImplementStackUsingQueues {
    void push(int x);
    int pop();
    int top();
    boolean empty();

    class ImplementStackUsingTwoQueues implements ImplementStackUsingQueues {
        private Queue<Integer> q1 = new ArrayDeque<>();
        private Queue<Integer> q2 = new ArrayDeque<>();
        private int top = -1;

        // O(1) time
        @Override
        public void push(int x) {
            q1.offer(x);
            top = x;
        }

        // O(N) time
        @Override
        public int pop() {
            while (q1.size() > 1) {
                top = q1.poll();
                q2.offer(top);
            }

            int last = q1.poll();
            // swap q1 with q2 to avoid copying all elements from q2 to q1
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
            return last;
        }

        // O(1) time
        @Override
        public int top() {
            return top;
        }

        // O(1) time
        @Override
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    class ImplementStackUsingOneQueue implements ImplementStackUsingQueues {
        private final Queue<Integer> q = new ArrayDeque<>();

        // O(N) time
        @Override
        public void push(int x) {
            int size = q.size();
            q.offer(x);
            // reverse the order of elements stored in the queue
            while (size-- > 0) {
                q.offer(q.poll());
            }
        }

        // O(1) time
        @Override
        public int pop() {
            return q.poll();
        }

        @Override
        public int top() {
            return q.peek();
        }

        @Override
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
