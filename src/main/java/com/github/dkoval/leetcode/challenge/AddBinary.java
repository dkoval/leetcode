package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/add-binary">Add Binary</a>
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= a.length, b.length <= 104</li>
 *  <li>a and b consist only of '0' or '1' characters.</li>
 *  <li>Each string does not contain leading zeros except for the zero itself.</li>
 * </ul>
 */
public interface AddBinary {

    String addBinary(String a, String b);

    class AddBinaryRev2 implements AddBinary {

        @Override
        public String addBinary(String a, String b) {
            final var sb = new StringBuilder();

            var carry = 0;
            var index1 = a.length() - 1;
            var index2 = b.length() - 1;
            while (index1 >= 0 || index2 >= 0) {
                var x = carry;
                if (index1 >= 0) {
                    x += a.charAt(index1) - '0';
                    index1--;
                }

                if (index2 >= 0) {
                    x += b.charAt(index2) - '0';
                    index2--;
                }

                sb.append(x % 2);
                carry = x / 2;
            }

            if (carry > 0) {
                sb.append(carry);
            }

            return sb.reverse().toString();
        }
    }
}
