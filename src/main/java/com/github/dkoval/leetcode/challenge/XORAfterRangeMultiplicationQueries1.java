package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/xor-after-range-multiplication-queries-i/">XOR After Range Multiplication Queries I</a>
 * <p>
 * You are given an integer array nums of length n and a 2D integer array queries of size q, where queries[i] = [li, ri, ki, vi].
 * <p>
 * For each query, you must apply the following operations in order:
 * <p>
 * Set idx = li.
 * <p>
 * While idx <= ri:
 * <p>
 * Update: nums[idx] = (nums[idx] * vi) % (10^9 + 7)
 * <p>
 * Set idx += ki.
 * <p>
 * Return the bitwise XOR of all elements in nums after processing all queries.
 */
public interface XORAfterRangeMultiplicationQueries1 {

    int MOD = 1_000_000_007;

    int xorAfterQueries(int[] nums, int[][] queries);

    class XORAfterRangeMultiplicationQueries1Rev1 implements XORAfterRangeMultiplicationQueries1 {

        @Override
        public int xorAfterQueries(int[] nums, int[][] queries) {
            for (var query : queries) {
                final var l = query[0];
                final var r = query[1];
                final var k = query[2];
                final var v = query[3];

                var idx = l;
                while (idx <= r) {
                    var value = (long) nums[idx];
                    value *= v;
                    value %= MOD;
                    nums[idx] = (int) value;
                    idx += k;
                }
            }

            var res = 0;
            for (var x : nums) {
                res ^= x;
            }
            return res;
        }
    }
}
