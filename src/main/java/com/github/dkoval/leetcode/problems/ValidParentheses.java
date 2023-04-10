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
 * <p>
 * Open brackets must be closed in the correct order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^4</li>
 *  <li>s consists of parentheses only '()[]{}'.</li>
 * </ul>
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
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (open.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != matching.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
