package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/lexicographical-numbers/">Lexicographical Numbers</a>
 * <p>
 * Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
 * <p>
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 5 * 10^4
 */
public interface LexicographicalNumbers {

    List<Integer> lexicalOrder(int n);

    class LexicographicalNumbersRev1 implements LexicographicalNumbers {

        @Override
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new ArrayList<>();
            int x = 1;
            while (ans.size() < n) {
                ans.add(x);
                if (x * 10 <= n) {
                    x *= 10;
                } else {
                    while (x == n || x % 10 == 9) {
                        // remove last digit
                        x /= 10;
                    }
                    x++;
                }
            }
            return ans;
        }
    }
}
