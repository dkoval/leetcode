package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/">Remove All Adjacent Duplicates in String II</a>
 * <p>
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them
 * causing the left and the right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.
 * <p>
 * It is guaranteed that the answer is unique.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>2 <= k <= 10^4</li>
 *  <li>s only contains lower case English letters</li>
 * </ul>
 */
public class RemoveAllAdjacentDuplicatesInString2 {

    private static class CharAndCount {
        final char c;
        int count;

        CharAndCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    // O(N) time | O(N) space
    public String removeDuplicates(String s, int k) {
        Deque<CharAndCount> dq = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dq.isEmpty() || dq.peekLast().c != c) {
                dq.offerLast(new CharAndCount(c, 1));
            } else {
                CharAndCount last = dq.peekLast();
                last.count++;
                if (last.count == k) {
                    dq.pollLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            CharAndCount curr = dq.pollFirst();
            while (curr.count-- > 0) {
                sb.append(curr.c);
            }
        }
        return sb.toString();
    }
}
