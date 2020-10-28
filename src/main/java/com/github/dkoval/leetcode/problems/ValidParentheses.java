package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a>
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {
    private static final Set<Character> open = new HashSet<>();
    private static final Map<Character, Character> matching = new HashMap<>();

    static {
        matching.put(')', '(');
        matching.put('}', '{');
        matching.put(']', '[');
        open.addAll(matching.values());
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (open.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (matching.get(c) != stack.peek()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
