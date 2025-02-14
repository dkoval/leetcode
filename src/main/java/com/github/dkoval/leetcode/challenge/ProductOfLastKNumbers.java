package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/product-of-the-last-k-numbers/">Product of the Last K Numbers</a>
 * <p>
 * Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.
 * <p>
 * Implement the ProductOfNumbers class:
 * <ul>
 *  <li>ProductOfNumbers() Initializes the object with an empty stream.</li>
 *  <li>void add(int num) Appends the integer num to the stream.</li>
 *  <li>int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.</li>
 * </ul>
 * The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= num <= 100</li>
 *  <li>1 <= k <= 4 * 10^4</li>
 *  <li>At most 4 * 10^4 calls will be made to add and getProduct.</li>
 *  <li>The product of the stream at any point in time will fit in a 32-bit integer.</li>
 * </ul>
 */
public interface ProductOfLastKNumbers {

    interface ProductOfNumbers {
        void add(int num);

        int getProduct(int k);
    }

    class ProductOfNumbersRev1 implements ProductOfNumbers {

        private List<Integer> prefix = new ArrayList<>();

        public void add(int num) {
            if (num == 0) {
                // reset
                prefix = new ArrayList<>();
                return;
            }

            final var n = prefix.size();
            final var prev = (n > 0) ? prefix.get(n - 1) : 1;
            prefix.add(num * prev);
        }

        public int getProduct(int k) {
            final var n = prefix.size();
            if (k > n) {
                return 0;
            }
            return prefix.get(n - 1) / (n - k - 1 >= 0 ? prefix.get(n - k - 1) : 1);
        }
    }
}
