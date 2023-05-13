package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/count-ways-to-build-good-strings/">Count Ways To Build Good Strings Medium</a>
 * <p>
 * Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:
 * <ul>
 *  <li>Append the character '0' zero times.</li>
 *  <li>Append the character '1' one times.</li>
 * </ul>
 * This can be performed any number of times.
 * <p>
 * A good string is a string constructed by the above process having a length between low and high (inclusive).
 * <p>
 * Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= low <= high <= 10^5</li>
 *  <li>1 <= zero, one <= low</li>
 * </ul>
 */
public interface CountWaysToBuildGoodStrings {

    int MOD = 1_000_000_007;

    int countGoodStrings(int low, int high, int zero, int one);

    class CountWaysToBuildGoodStringsDPTopDownRev1 implements CountWaysToBuildGoodStrings {

        @Override
        public int countGoodStrings(int low, int high, int zero, int one) {
            // dp[i] is the number of ways to build "good" strings of length i
            Map<Integer, Integer> dp = new HashMap<>();
            int count = 0;
            for (int len = low; len <= high; len++) {
                count += calculate(zero, one, len, dp);
                count %= MOD;
            }
            return count;
        }

        private int calculate(int zero, int one, int len, Map<Integer, Integer> dp) {
            // base case
            if (len == 0) {
                return 1;
            }

            // already solved?
            if (dp.containsKey(len)) {
                return dp.get(len);
            }

            int count = 0;

            // option #1: take "0" zero times
            if (len >= zero) {
                count += calculate(zero, one, len - zero, dp);
                count %= MOD;
            }

            // option #2: take "1" one times
            if (len >= one) {
                count += calculate(zero, one, len - one, dp);
                count %= MOD;
            }

            // cache and return the answer
            dp.put(len, count);
            return count;
        }
    }

    class CountWaysToBuildGoodStringsDPTopDownRev2 implements CountWaysToBuildGoodStrings {

        @Override
        public int countGoodStrings(int low, int high, int zero, int one) {
            // dp[i] the numbeof ways to build "good" strings of length i
            Map<Integer, Integer> dp = new HashMap<>();
            return calculate(low, high, zero, one, 0, dp);
        }

        private int calculate(int low, int high, int zero, int one, int len, Map<Integer, Integer> dp) {
            // base case
            if (len > high) {
                return 0;
            }

            // already solved?
            if (dp.containsKey(len)) {
                return dp.get(len);
            }

            int count = (len >= low) ? 1 : 0;

            // option #1: take "0" zero times
            count += calculate(low, high, zero, one, len + zero, dp);
            count %= MOD;

            // option #2: take "1" one times
            count += calculate(low, high, zero, one, len + one, dp);
            count %= MOD;

            // cache and return the answer
            dp.put(len, count);
            return count;
        }
    }
}
