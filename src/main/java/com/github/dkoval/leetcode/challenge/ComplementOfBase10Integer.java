package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/complement-of-base-10-integer/">Complement of Base 10 Integer</a>
 * <p>
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
 * <p>
 * For example, integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer n, return its complement.
 * <p>
 * Constraints:
 * <p>
 * 0 <= n < 10^9
 */
public interface ComplementOfBase10Integer {

    int bitwiseComplement(int n);

    class ComplementOfBase10IntegerRev1 implements ComplementOfBase10Integer {

        @Override
        public int bitwiseComplement(int n) {
            var numBits = countBits(n);
            var mask = (1 << numBits) - 1;
            return mask ^ n;
        }

        private int countBits(int x) {
            var count = 0;
            while (x != 0) {
                x >>= 1;
                count++;
            }
            return (count > 0) ? count : 1;
        }
    }

    class ComplementOfBase10IntegerRev2 implements ComplementOfBase10Integer {

        @Override

        public int bitwiseComplement(int n) {
            if (n == 0) {
                return 1;
            }

            var i = 0;
            var res = 0;
            while (n > 0) {
                var bit = (n & 1) ^ 1;
                res |= (bit << i);
                n >>= 1;
                i++;
            }
            return res;
        }
    }
}
