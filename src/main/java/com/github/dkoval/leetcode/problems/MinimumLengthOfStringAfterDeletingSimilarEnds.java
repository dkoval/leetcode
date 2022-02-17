package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/">Minimum Length of String After Deleting Similar Ends</a>
 * <p>
 * Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
 * <ul>
 *  <li>Pick a non-empty prefix from the string s where all the characters in the prefix are equal.</li>
 *  <li> Pick a non-empty suffix from the string s where all the characters in this suffix are equal.</li>
 *  <li>The prefix and the suffix should not intersect at any index.</li>
 *  <li>The characters from the prefix and suffix must be the same.</li>
 *  <li>Delete both the prefix and the suffix.</li>
 * </ul>
 * Return the minimum length of s after performing the above operation any number of times (possibly zero times).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s only consists of characters 'a', 'b', and 'c'</li>
 * </ul>
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            // remove prefix consisting of equal chars
            char c = s.charAt(left);
            left++;
            while (left < right && s.charAt(left) == c) {
                left++;
            }

            // remove suffix consisting of equal chars
            c = s.charAt(right);
            right--;
            while (right > left && s.charAt(right) == c) {
                right--;
            }
        }
        return (left <= right) ? right - left + 1 : 0;
    }
}
