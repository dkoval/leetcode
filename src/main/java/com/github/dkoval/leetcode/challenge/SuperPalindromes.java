package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3736/">Super Palindromes</a>
 * <p>
 * Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
 * <p>
 * Given two positive integers left and right represented as strings, return the number of super-palindromes integers
 * in the inclusive range [left, right].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= left.length, right.length <= 18</li>
 *  <li>left and right consist of only digits</li>
 *  <li>left and right cannot have leading zeros</li>
 *  <li>left and right represent integers in the range [1, 10^18]</li>
 *  <li>left is less than or equal to right</li>
 * </ul>
 */
public class SuperPalindromes {

    public int superpalindromesInRange(String left, String right) {
        long lo = Long.parseLong(left);
        long hi = Long.parseLong(right);

        // count even-length super-palindromes
        int count = countSuperPalindromesInRange(lo, hi, true);
        // count odd-length super-palindromes
        count += countSuperPalindromesInRange(lo, hi, false);
        return count;
    }

    private int countSuperPalindromesInRange(long lo, long hi, boolean evenLength) {
        int count = 0;
        int i = 1;
        while (true) {
            long n = generatePalindrome(i, evenLength);
            n *= n;
            if (n > hi) {
                break;
            }
            if (n >= lo && isPalindrome(n)) {
                count++;
            }
            i++;
        }
        return count;
    }

    private long generatePalindrome(int n, boolean evenLength) {
        // Example: n = 123, even-length = 123|321, odd-length = 123|21
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int length = evenLength ? sb.length() : sb.length() - 1;
        for (int i = length - 1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }

    private boolean isPalindrome(long n) {
        return n == reverse(n);
    }

    private long reverse(long n) {
        long result = 0;
        while (n != 0) {
            result *= 10;
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
