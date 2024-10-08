package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/">Minimum Number of Swaps to Make the String Balanced</a>
 * <p>
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
 * <p>
 * A string is called balanced if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB, where both A and B are balanced strings, or
 * It can be written as [C], where C is a balanced string.
 * You may swap the brackets at any two indices any number of times.
 * <p>
 * Return the minimum number of swaps to make s balanced.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == s.length</li>
 *  <li>2 <= n <= 106</li>
 *  <li>n is even.</li>
 *  <li>s[i] is either '[' or ']'.</li>
 *  <li>The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.</li>
 * </ul>
 */
public interface MinimumNumberOfSwapsToMakeStringBalanced {

    int minSwaps(String s);

    // O(N) time | O(N) space
    class MinimumNumberOfSwapsToMakeStringBalancedRev1 implements MinimumNumberOfSwapsToMakeStringBalanced {

        @Override
        public int minSwaps(String s) {
            int n = s.length();

            int unmatched = 0;
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack.push(c);
                } else {
                    // c == ']'
                    if (!stack.isEmpty()) {
                        // match '[' with ']'
                        stack.pop();
                    } else {
                        unmatched++;
                    }
                }
            }

            // Constraint: The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
            //
            // Example 1
            // input = ][
            // swap1 = []
            //
            // Example 2
            // input = ]][[
            // swap1 = [][]
            //         ^  ^
            //
            // Example 3
            // input = ]]][[[
            // swap1 = []][[]
            //         ^    ^
            // swap2 = [][][]
            //           ^^
            return (unmatched + 1) / 2;
        }
    }
}
