package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/">Max Difference You Can Get From Changing an Integer</a>
 * <p>
 * You are given an integer num. You will apply the following steps to num two separate times:
 * <ul>
 *  <li>Pick a digit x (0 <= x <= 9).</li>
 *  <li>Pick another digit y (0 <= y <= 9). Note y can be equal to x.</li>
 *  <li>Replace all the occurrences of x in the decimal representation of num by y.</li>
 * </ul>
 * Let a and b be the two results from applying the operation to num independently.
 * <p>
 * Return the max difference between a and b.
 * <p>
 * Note that neither a nor b may have any leading zeros, and must not be 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 10^8
 */
public interface MaxDifferenceYouCanGetFromChangingInteger {

    int maxDiff(int num);

    class MaxDifferenceYouCanGetFromChangingIntegerRev1 implements MaxDifferenceYouCanGetFromChangingInteger {

        @Override
        public int maxDiff(int num) {
            final var digits = Integer.toString(num);
            var max = 0;
            var min = num;

            // brute force
            for (var x = '0'; x <= '9'; x++) {
                for (var y = '0'; y <= '9'; y++) {
                    final var curr = replace(digits, x, y);
                    if (curr == 0) {
                        continue;
                    }
                    max = Math.max(max, curr);
                    min = Math.min(min, curr);
                }
            }
            return max - min;
        }

        private int replace(String digits, char x, char y) {
            var ans = 0;
            for (var i = 0; i < digits.length(); i++) {
                // replace x -> y
                var c = digits.charAt(i);
                if (c == x) {
                    c = y;
                }

                // avoid leading zeros
                if (c == '0' && ans == 0) {
                    return 0;
                }

                ans *= 10;
                ans += c - '0';
            }
            return ans;
        }
    }
}
