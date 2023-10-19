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

    // O(S + T) time | O(S + T) space, where S, T are the lengths of s and t respectively
    class BackspaceStringCompareUsingStack implements BackspaceStringCompare {

        @Override
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

    // O(S + T) time | O(S + T) space, where S, T are the lengths of s and t respectively
    class BackspaceStringCompareUsingStringBuilder implements BackspaceStringCompare {

        @Override
        public boolean backspaceCompare(String s, String t) {
            String sClean = clean(s);
            String tClean = clean(t);
            return sClean.equals(tClean);
        }

        private String clean(String s) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '#') {
                    if (sb.length() != 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    // Resource: https://leetcode.com/problems/backspace-string-compare/solution/
    // O(S + T) time | O(1) space, where S, T are the lengths of s and t respectively
    class BackspaceStringCompareUsingTwoPointersRev1 implements BackspaceStringCompare {

        @Override
        public boolean backspaceCompare(String s, String t) {
            int i = s.length() - 1;
            int j = t.length() - 1;

            // While there are chars in either s or t
            while (i >= 0 || j >= 0) {
                // Find position of the next possible char in s
                i = readCharFromRight(s, i);

                // Find position of the next possible char in t
                j = readCharFromRight(t, j);

                // If two actual characters are different
                if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                    return false;
                }

                // If expecting to compare char vs nothing:
                if ((i >= 0 && j < 0) || (j >= 0 && i < 0)) {
                    return false;
                }

                // Proceed to the next char in both s and t
                i--;
                j--;
            }
            return true;
        }

        private int readCharFromRight(String s, int from) {
            int i = from;
            int numBackspaces = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    numBackspaces++;
                    i--;
                } else {
                    if (numBackspaces > 0) {
                        // skip a letter if there was a backspace to the right of it
                        numBackspaces--;
                        i--;
                    } else {
                        // take a letter at index i
                        break;
                    }
                }
            }
            return i;
        }
    }

    class BackspaceStringCompareUsingTwoPointersRev2 implements BackspaceStringCompare {

        @Override
        public boolean backspaceCompare(String s, String t) {
            int index1 = s.length() - 1;
            int index2 = t.length() - 1;
            while (index1 >= 0 || index2 >= 0) {
                index1 = findNextLetter(s, index1);
                index2 = findNextLetter(t, index2);

                char c1 = (index1 >= 0) ? s.charAt(index1) : '_';
                char c2 = (index2 >= 0) ? t.charAt(index2) : '_';
                if (c1 != c2) {
                    return false;
                }

                index1--;
                index2--;
            }
            return true;
        }

        private int findNextLetter(String str, int index) {
            int backspaces = 0;
            while (index >= 0) {
                if (str.charAt(index) == '#') {
                    backspaces++;
                } else {
                    if (backspaces > 0) {
                        // can't take this char yet
                        backspaces--;
                    } else {
                        break;
                    }
                }
                index--;
            }
            return index;
        }
    }
}
