package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/removing-stars-from-a-string/">Removing Stars From a String</a>
 * <p>
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <ul>
 *  <li>Choose a star in s.</li>
 *  <li>Remove the closest non-star character to its left, as well as remove the star itself.</li>
 * </ul>
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <ul>
 *  <li>The input will be generated such that the operation is always possible.</li>
 *  <li>It can be shown that the resulting string will always be unique.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of lowercase English letters and stars *.</li>
 *  <li>The operation above can be performed on s.</li>
 * </ul>
 */
public interface RemovingStarsFromString {

    String removeStars(String s);

    // O(N) time | O(N) space
    class RemovingStarsFromStringRev1 implements RemovingStarsFromString {

        @Override
        public String removeStars(String s) {
            int n = s.length();

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c != '*') {
                    stack.push(c);
                } else {
                    // the input is generated such that the operation is always possible
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
}
