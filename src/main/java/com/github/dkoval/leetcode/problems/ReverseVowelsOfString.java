package com.github.dkoval.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">Reverse Vowels of a String</a>
 * <p>
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 3 * 10^5</li>
 *  <li>s consist of printable ASCII characters</li>
 * </ul>
 */
public class ReverseVowelsOfString {

    private static final Set<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');
    }

    // O(N) time | O(1) space
    public String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            boolean leftLetterIsVowel = isVowel(letters[left]);
            boolean rightLetterIsVowel = isVowel(letters[right]);

            if (leftLetterIsVowel && rightLetterIsVowel) {
                swap(letters, left, right);
                left++;
                right--;
                continue;
            }

            if (!leftLetterIsVowel) {
                left++;
            }

            if (!rightLetterIsVowel) {
                right--;
            }
        }
        return new String(letters);
    }

    private boolean isVowel(char c) {
        return VOWELS.contains(c);
    }

    private void swap(char[] letters, int i, int j) {
        if (i != j && letters[i] != letters[j]) {
            char tmp = letters[i];
            letters[i] = letters[j];
            letters[j] = tmp;
        }
    }
}
