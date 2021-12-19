package com.github.dkoval.leetcode.challenge;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/decode-string/">Decode String</a>
 * <p>
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 30</li>
 *  <li>s consists of lowercase English letters, digits, and square brackets '[]'</li>
 *  <li>s is guaranteed to be a valid input</li>
 *  <li>All the integers in s are in the range [1, 300]</li>
 * </ul>
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                // form a segment to repeat
                StringBuilder segment = new StringBuilder();
                while (!stack.peek().equals('[')) {
                    segment.append(stack.pop());
                }

                // pop off '[' character
                stack.pop();

                // repeat the segment k times
                segment.reverse();
                int times = (Integer) stack.pop();
                while (times-- > 0) {
                    for (int j = 0; j < segment.length(); j++) {
                        stack.push(segment.charAt(j));
                    }
                }
            } else {
                // '[', other char or digit
                if (Character.isDigit(c)) {
                    int top = !stack.isEmpty() && stack.peek() instanceof Integer
                            ? (Integer) stack.pop() : 0;
                    stack.push(top * 10 + (c - '0'));
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Object o : stack) {
            ans.append(o);
        }
        return ans.toString();
    }
}
