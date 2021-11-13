package com.github.dkoval.leetcode.problems;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare/">Backspace String Compare</a>
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length, t.length <= 200</li>
 *  <li>s and t only contain lowercase letters and '#' characters</li>
 * </ul>
 */
public interface BackspaceStringCompare {

    boolean backspaceCompare(String s, String t);

    class BackspaceStringCompareUsingStack implements BackspaceStringCompare {

        public boolean backspaceCompare(String s, String t) {
            Stack<Character> sStack = clean(s);
            Stack<Character> tStack = clean(t);
            return sStack.equals(tStack);
        }

        private Stack<Character> clean(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '#') {
                    stack.push(s.charAt(i));
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
            return stack;
        }
    }
}
