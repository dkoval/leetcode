package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/find-unique-binary-string/">Find Unique Binary String</a>
 * <p>
 * Given an array of strings nums containing n unique binary strings each of length n,
 * return a binary string of length n that does not appear in nums.
 * If there are multiple answers, you may return any of them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= n <= 16</li>
 *  <li>nums[i].length == n</li>
 *  <li>nums[i] is either '0' or '1'</li>
 *  <li>All the strings of nums are unique</li>
 * </ul>
 */
public interface FindUniqueBinaryString {

    String findDifferentBinaryString(String[] nums);

    class FindUniqueBinaryStringRev1 implements FindUniqueBinaryString {

        @Override
        public String findDifferentBinaryString(String[] nums) {
            int n = nums.length;

            Set<Integer> available = new HashSet<>();
            for (String x : nums) {
                available.add(toBinaryNumber(x));
            }

            // With n bits we can code 2^n = (1 << n) numbers:
            // 00...0
            // 00...1
            // 11...1
            for (int x = 0; x < (1 << n); x++) {
                if (!available.contains(x)) {
                    return toBinaryString(x, n);
                }
            }
            return "";
        }

        private int toBinaryNumber(String s) {
            int x = 0;
            for (int i = 0; i < s.length(); i++) {
                x *= 2;
                x += s.charAt(i) - '0';
            }
            return x;
        }

        private String toBinaryString(int x, int length) {
            StringBuilder sb = new StringBuilder();
            while (x > 0) {
                sb.append(x % 2);
                x /= 2;
            }

            while (sb.length() < length) {
                sb.append(0);
            }

            return sb.reverse().toString();
        }
    }
}
