package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">Remove All Adjacent Duplicates In String</a>
 * <p>
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent
 * and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of lowercase English letters</li>
 * </ul>
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

            char[] ans = new char[stack.size()];
            int i = stack.size() - 1;
            while (!stack.isEmpty()) {
                ans[i--] = stack.pop();
            }
            return String.valueOf(ans);
        }
    }

    class RemoveAllAdjacentDuplicatesInStringUsingDeque implements RemoveAllAdjacentDuplicatesInString {

        @Override
        public String removeDuplicates(String s) {
            Deque<Character> dq = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                if (dq.isEmpty() || dq.peekLast() != s.charAt(i)) {
                    dq.offerLast(s.charAt(i));
                } else {
                    dq.pollLast();
                }
            }

            StringBuilder ans = new StringBuilder();
            while (!dq.isEmpty()) {
                ans.append(dq.pollFirst());
            }
            return ans.toString();
        }
    }
}
