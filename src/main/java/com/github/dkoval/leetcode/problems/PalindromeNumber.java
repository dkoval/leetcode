package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/">Palindrome Number</a>
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 */
public abstract class PalindromeNumber {

    public abstract boolean isPalindrome(int x);

    public static class PalindromeNumberConvertToString extends PalindromeNumber {

        @Override
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            String s = String.valueOf(x);
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) return false;
            }
            return true;
        }
    }

    public static class PalindromeNumberReverseHalfOfNumber extends PalindromeNumber {

        @Override
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            int revertedX = 0;
            // revert and compare half of the number x
            while (x > revertedX) {
                revertedX = revertedX * 10 + x % 10;
                x /= 10;
            }
            return x == revertedX
                    || x == revertedX / 10; // remove middle digit if original x is of odd length
        }
    }
}
