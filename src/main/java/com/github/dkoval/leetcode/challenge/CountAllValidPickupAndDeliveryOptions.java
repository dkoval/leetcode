package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/">Count All Valid Pickup and Delivery Options (Hard)</a>
 * <p>
 * Given n orders, each order consist in pickup and delivery services.
 * <p>
 * Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 500
 */
public class CountAllValidPickupAndDeliveryOptions {

    private static final int MOD = 1_000_000_007;

    public int countOrders(int n) {
        // dp[i] is the number of valid pickup/delivery sequences of i orders
        int[] dp = new int[n + 1];
        dp[1] = 1; // (P1, D1), (D1, P1) is considered invalid

        // N = 2
        //
        // There are 3 places where (P2, D2) can be placed:
        //
        // _ P1 _ D1 _
        // ^ => 3 possibilities to place D2
        // ---
        // _ P1 _ D1 _
        //      ^ => 2 possibilities to place D2
        // ---
        // _ P1 _ D1 _
        //           ^ => 1 possibility to place D2
        //
        // 1 + 2 + 3 = 6 possibilities in total
        // ---
        // 1 + 2 + ... + N = N * (N + 1) / 2
        for (int i = 2; i <= n; i++) {
            int numPlaces = 2 * i - 1;
            int numPossibilities = numPlaces * (numPlaces + 1) / 2;

            long x = ((long) dp[i - 1]) * numPossibilities;
            dp[i] = (int) (x % MOD);
        }
        return dp[n];
    }
}
