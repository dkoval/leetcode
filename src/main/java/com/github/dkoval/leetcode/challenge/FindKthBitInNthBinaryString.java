package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/">Find Kth Bit in Nth Binary String</a>
 * <p>
 * Given two positive integers n and k, the binary string Sn is formed as follows:
 * <ul>
 *  <li>S1 = "0"</li>
 *  <li>Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1</li>
 * </ul>
 * Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts
 * all the bits in x (0 changes to 1 and 1 changes to 0).
 * <p>
 * For example, the first four strings in the above sequence are:
 * <ul>
 *  <li>S1 = "0"</li>
 *  <li>S2 = "011"</li>
 *  <li>S3 = "0111001"</li>
 *  <li>S4 = "011100110110001"</li>
 * </ul>
 * Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
 */
public interface FindKthBitInNthBinaryString {

    char findKthBit(int n, int k);

    class FindKthBitInNthBinaryStringRev1 implements FindKthBitInNthBinaryString {

        @Override
        public char findKthBit(int n, int k) {
            // idea: simulation
            StringBuilder s = new StringBuilder("0");
            while (n-- > 0) {
                // reverse(invert(Si - 1))
                StringBuilder suffix = new StringBuilder();
                for (int i = s.length() - 1; i >= 0; i--) {
                    suffix.append(s.charAt(i) == '0' ? '1' : '0');
                }
                // Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
                s.append('1').append(suffix);
            }
            return s.charAt(k - 1);
        }
    }
}
