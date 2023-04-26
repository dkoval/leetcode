package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/add-digits/">Add Digits</a>
 * <p>
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= num <= 2^31 - 1</li>
 * </ul>
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
public interface AddDigits {

    int addDigits(int num);

    class AddDigitsNaive implements AddDigits {

        @Override
        public int addDigits(int num) {
            int x = sumOfDigits(num);
            while (x > 9) {
                x = sumOfDigits(x);
            }
            return x;
        }

        private int sumOfDigits(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }
}
