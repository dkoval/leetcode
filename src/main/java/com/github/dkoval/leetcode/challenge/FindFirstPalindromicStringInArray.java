package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-first-palindromic-string-in-the-array/">Find First Palindromic String in the Array</a>
 * <p>
 * Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
 * <p>
 * A string is palindromic if it reads the same forward and backward.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 100</li>
 *  <li>1 <= words[i].length <= 100</li>
 *  <li>words[i] consists only of lowercase English letters</li>
 * </ul>
 */
public interface FindFirstPalindromicStringInArray {

    String firstPalindrome(String[] words);

    class FindFirstPalindromicStringInArrayRev1 implements FindFirstPalindromicStringInArray {

        @Override
        public String firstPalindrome(String[] words) {
            for (String word : words) {
                if (palindrome(word)) {
                    return word;
                }
            }
            return "";
        }

        private boolean palindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
