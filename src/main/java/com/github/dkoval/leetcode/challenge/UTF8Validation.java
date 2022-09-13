package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/utf-8-validation/">UTF-8 Validation</a>
 * <p>
 * Given an integer array data representing the data, return whether it is a valid UTF-8 encoding
 * (i.e. it translates to a sequence of valid UTF-8 encoded characters).
 * <p>
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * <p>
 * For a 1-byte character, the first bit is a 0, followed by its Unicode code.
 * For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0,
 * followed by n - 1 bytes with the most significant 2 bits being 10.
 * This is how the UTF-8 encoding would work:
 * <pre>
 * Number of Bytes     |        UTF-8 Octet Sequence
 *                     |              (binary)
 * --------------------+-----------------------------------------
 * 1                   |   0xxxxxxx
 * 2                   |   110xxxxx 10xxxxxx
 * 3                   |   1110xxxx 10xxxxxx 10xxxxxx
 * 4                   |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * </pre>
 * x denotes a bit in the binary form of a byte that may be either 0 or 1.
 * <p>
 * Note: The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data.
 * This means each integer represents only 1 byte of data.
 */
public interface UTF8Validation {

    boolean validUtf8(int[] data);

    // O(N) time | O(1) space
    class UTF8ValidationRev1 implements UTF8Validation {

        @Override
        public boolean validUtf8(int[] data) {
            int numBytes = 0;
            for (int x : data) {
                if (numBytes > 0) {
                    // each next byte must be of "10xxxxxx" form, i.e. starting with "10"
                    if (x >>> 6 != 0b10) {
                        return false;
                    }
                    numBytes--;
                } else {
                    numBytes = getNumBytesToReadAfter(x);
                    if (numBytes < 0) {
                        return false;
                    }
                }
            }
            return numBytes == 0;
        }

        private int getNumBytesToReadAfter(int x) {
            if (x >>> 7 == 0) {
                // x denotes 1-byte character
                return 0;
            }

            if (x >>> 5 == 0b110) {
                // x denotes 2-bytes character
                return 1;
            }

            if (x >>> 4 == 0b1110) {
                // x denotes 3-bytes character
                return 2;
            }

            if (x >>> 3 == 0b11110) {
                // x denotes 4-bytes character
                return 3;
            }

            // not valid UTF-8 encoding
            return -1;
        }
    }
}
