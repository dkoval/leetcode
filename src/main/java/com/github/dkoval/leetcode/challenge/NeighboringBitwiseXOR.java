package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/neighboring-bitwise-xor/">Neighboring Bitwise XOR</a>
 * <p>
 * A 0-indexed array derived with length n is derived by computing the bitwise XOR (⊕) of adjacent values in a binary array original of length n.
 * <p>
 * Specifically, for each index i in the range [0, n - 1]:
 * <ul>
 *  <li>If i = n - 1, then derived[i] = original[i] ⊕ original[0].</li>
 *  <li>Otherwise, derived[i] = original[i] ⊕ original[i + 1].</li>
 * </ul>
 * Given an array derived, your task is to determine whether there exists a valid binary array original that could have formed derived.
 * <p>
 * Return true if such an array exists or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == derived.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>The values in derived are either 0's or 1's</li>
 * </ul>
 */
public interface NeighboringBitwiseXOR {

    boolean doesValidArrayExist(int[] derived);

    // O(N) time | O(1) space
    class NeighboringBitwiseXORRev1 implements NeighboringBitwiseXOR {

        @Override
        public boolean doesValidArrayExist(int[] derived) {
            final var n = derived.length;

            // x ^ x = 0
            // x ^ 0 = x
            // Progressively reconstruct original[i]
            final var first = 0;
            var curr = 0;
            for (var x : derived) {
                // derived[i] = original[i] ^ original[i + 1]
                // original[i + 1] = derived[i] ^ original[i]
                curr ^= x;
            }
            return curr == first;
        }
    }
}
