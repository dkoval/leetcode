package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-69-number/">Maximum 69 Number</a>
 * <p>
 * You are given a positive integer num consisting only of digits 6 and 9.
 * <p>
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= num <= 10^4</li>
 *  <li>num consists of only 6 and 9 digits.</li>
 * </ul>
 */
public interface Maximum69Number {

    int maximum69Number (int num);

    // O(N) time | O(N) space, where N is the number of digits
    class Maximum69NumberRev1 implements Maximum69Number {

        @Override
        public int maximum69Number(int num) {
            // convert num to mutable string
            StringBuilder ans = new StringBuilder();
            ans.append(num);

            // replace 6 with 9 in the highest possible position
            for (int i = 0; i < ans.length(); i++) {
                if (ans.charAt(i) == '6') {
                    ans.setCharAt(i, '9');
                    break;
                }
            }
            return Integer.parseInt(ans.toString());
        }
    }
}
