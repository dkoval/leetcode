package com.github.dkoval.leetcode.challenge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3794/">Remove All Adjacent Duplicates In String</a>
 * <p>
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent
 * and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 */
public interface RemoveAllAdjacentDuplicatesInString {

    String removeDuplicates(String s);

    class RemoveAllAdjacentDuplicatesInStringUsingStack implements RemoveAllAdjacentDuplicatesInString {

        @Override
        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }

    class RemoveAllAdjacentDuplicatesInStringUsingDeque implements RemoveAllAdjacentDuplicatesInString {

        @Override
        public String removeDuplicates(String s) {
            Deque<Character> dq = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (dq.isEmpty() || dq.peekLast() != s.charAt(i)) {
                    dq.offerLast(s.charAt(i));
                } else {
                    dq.pollLast();
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!dq.isEmpty()) {
                sb.append(dq.pollFirst());
            }
            return sb.toString();
        }
    }
}
