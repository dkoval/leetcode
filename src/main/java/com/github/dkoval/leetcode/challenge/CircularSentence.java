package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/circular-sentence/">Circular Sentence</a>
 * <p>
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * <p>
 * For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
 * Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered
 * different.
 * <p>
 * A sentence is circular if:
 * <ul>
 *  <li>The last character of a word is equal to the first character of the next word.</li>
 *  <li>The last character of the last word is equal to the first character of the first word.</li>
 * </ul>
 * For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences.
 * However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.
 * <p>
 * Given a string sentence, return true if it is circular. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= sentence.length <= 500</li>
 *  <li>sentence consist of only lowercase and uppercase English letters and spaces.</li>
 *  <li>The words in sentence are separated by a single space.</li>
 *  <li>There are no leading or trailing spaces.</li>
 * </ul>
 */
public interface CircularSentence {

    boolean isCircularSentence(String sentence);

    // O(N) time | O(1) space
    class CircularSentenceRev1 implements CircularSentence {

        @Override
        public boolean isCircularSentence(String sentence) {
            int n = sentence.length();

            if (sentence.charAt(0) != sentence.charAt(n - 1)) {
                return false;
            }

            int i = 0;
            while (i < n) {
                // jump to the end of the current word
                while (i < n && sentence.charAt(i) != ' ') {
                    i++;
                }
                // compare the first character of the next word with the last character of the current word
                if (i + 1 < n && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                    return false;
                }
                // skip a whitespace
                i++;
            }
            return true;
        }
    }
}
