package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3491/">Remove Duplicate Letters</a>
 * <p>
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Note: This question is the same as 1081:
 * <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/">Smallest Subsequence of Distinct Characters</a>
 */
public abstract class RemoveDuplicateLetters {

    public abstract String removeDuplicateLetters(String s);

    public static class RemoveDuplicateLettersGreedySolvingWithStack extends RemoveDuplicateLetters {

        @Override
        public String removeDuplicateLetters(String s) {
            // As we iterate over our string, if character i is greater than character (i + 1) and another occurrence of
            // character i exists later in the string, deleting character i will always lead to the optimal solution.
            Map<Character, Integer> lastAppearedIndex = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                lastAppearedIndex.put(s.charAt(i), i);
            }

            // At each iteration we add the current character to the solution if it hasn't already been used.
            // We try to remove as many characters as possible off the top of the stack, and then add
            // the current character.
            //
            // The conditions for deletion are:
            //
            // - The character is greater than the current characters.
            // - The character can be removed because it occurs later on.
            Stack<Character> stack = new Stack<>(); // chars in asc order
            Set<Character> used = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (used.contains(c)) continue;

                while (!stack.isEmpty() && c < stack.peek() && lastAppearedIndex.get(stack.peek()) > i) {
                    char top = stack.pop();
                    used.remove(top);
                }

                used.add(c);
                stack.push(c);
            }

            StringBuilder sb = new StringBuilder(stack.size());
            for (char c : stack) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
