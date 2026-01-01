package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/plus-one/">Plus One</a>
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array
 * contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= digits.length <= 100</li>
 *  <li>0 <= digits[i] <= 9</li>
 *  <li>digits does not contain any leading 0's.</li>
 * </ul>
 */
public interface PlusOne {

    int[] plusOne(int[] digits);

    class PlusOneJavaRev1 implements PlusOne {

        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i] += 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }

            if (digits[0] == 0) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }
            return digits;
        }
    }

    class PlusOneJavaRev2 implements PlusOne {

        @Override
        public int[] plusOne(int[] digits) {
            final var n = digits.length;

            digits[n - 1] += 1;
            var carry = digits[n - 1] / 10;
            digits[n - 1] %= 10;

            for (var i = n - 2; i >= 0 && carry > 0; i--) {
                digits[i] += carry;
                carry = digits[i] / 10;
                digits[i] %= 10;
            }

            var ans = digits;
            if (carry > 0) {
                ans = new int[n + 1];
                ans[0] = carry;
                System.arraycopy(digits, 0, ans, 1, n);
            }
            return ans;
        }
    }
}
