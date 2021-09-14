package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3974/">Reverse Only Letters</a>
 * <p>
 * Given a string s, reverse the string according to the following rules:
 * <p>
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s consists of characters with ASCII values in the range [33, 122]</li>
 *  <li>s does not contain '\"' or '\\'</li>
 * </ul>
 */
public class ReverseOnlyLetters {

    // O(N) time | O(1) space
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            boolean leftOk = isEnglishLetter(chars[l]);
            boolean rightOk = isEnglishLetter(chars[r]);
            if (leftOk && rightOk) {
                // reverse
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            } else {
                // skip non-English letter from the left
                if (!leftOk) {
                    l++;
                }
                // skip non-English letter from the right
                if (!rightOk) {
                    r--;
                }
            }
        }
        return String.valueOf(chars);
    }

    private boolean isEnglishLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
