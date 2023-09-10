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
public interface CountAllValidPickupAndDeliveryOptions {

    int MOD = 1_000_000_007;

    int countOrders(int n);

    // O(N^2) time | O(N^2) space
    class CountAllValidPickupAndDeliveryOptionsDPTopDown implements CountAllValidPickupAndDeliveryOptions {

        @Override
        public int countOrders(int n) {
            Integer[][] dp = new Integer[n + 1][n + 1];
            return calculate(n, n, 0, dp);
        }

        private int calculate(int n, int pickups, int deliveries, Integer[][] dp) {
            if (pickups == 0 && deliveries == 0) {
                return 1;
            }

            // already solved?
            if (dp[pickups][deliveries] != null) {
                return dp[pickups][deliveries];
            }

            long count = 0;

            // option #1: pickup an order
            if (pickups > 0) {
                count += (long) pickups * calculate(n, pickups - 1, deliveries + 1, dp);
                count %= MOD;
            }

            // option #2: deliver an order
            if (deliveries > 0) {
                count += (long) deliveries * calculate(n, pickups, deliveries - 1, dp);
                count %= MOD;
            }

            // cache and return the answer
            return dp[pickups][deliveries] = (int) count;
        }
    }

    // O(N) time | O(N) space
    class CountAllValidPickupAndDeliveryOptionsDPBottomUp implements CountAllValidPickupAndDeliveryOptions {

        @Override
        public int countOrders(int n) {
            // dp[i] is the number of valid pickup/delivery sequences of i orders
            int[] dp = new int[n + 2];
            dp[1] = 1; // (P1, D1), (D1, P1) is considered invalid

            // N = 1
            //
            // P1 D1
            // 1 possibility
            //
            // N = 2
            //
            // There are 3 slots where (P2, D2) can be placed:
            //
            // _ P1 _ D1 _
            // ^ => 3 possibilities to place P2 in the 1st slot
            // ---
            // _ P1 _ D1 _
            //      ^ => 2 possibilities to place P2 in the 2nd slot
            // ---
            // _ P1 _ D1 _
            //           ^ => 1 possibility to place P2 in the 3rd slot
            //
            // 1 + 2 + 3 = 6 possibilities in total
            //
            // At this stage, we can start thinking of (P1, D1) as dividers
            // ---
            //
            // N = 3
            //
            // (P1, D1) and (P2, D2) are already placed
            // _ | _ | _ | _ | _
            // there are 5 (2 * 3 - 1) slots to put P3 in
            // 1 + 2 + 3 + 4 + 5 = 15 possibilities to put P3
            // answer = 15 * number of possibilities to place both (P1, D1) and (P2, D2) = 15 * F(N - 2)
            //
            // In general
            // F(1) = 1
            // F(N) = sum(1, 2 * N - 1) * F(N - 1)
            //
            // sum(1, N) = 1 + 2 + ... + N = N * (N + 1) / 2
            for (int i = 2; i <= n; i++) {
                int slots = 2 * i - 1;
                long choices = (long) slots * (slots + 1) / 2;
                choices *= dp[i - 1];
                choices %= MOD;
                dp[i] = (int) choices;
            }
            return dp[n];
        }
    }

    // O(N) time | O(1) space
    class CountAllValidPickupAndDeliveryOptionsDPBottomUpSpaceOptimized implements CountAllValidPickupAndDeliveryOptions {

        @Override
        public int countOrders(int n) {
            // base case: F(1) = 1
            int count = 1;
            for (int i = 2; i <= n; i++) {
                int slots = 2 * i - 1;
                long choices = (long) slots * (slots + 1) / 2;
                choices *= count;
                choices %= MOD;
                count = (int) choices;
            }
            return count;
        }
    }

        // O(N) time | O(1) space
    class CountAllValidPickupAndDeliveryOptionsDiscreteMath implements CountAllValidPickupAndDeliveryOptions {

        @Override
        public int countOrders(int n) {
            // 2 * n slots to put (P1, D1)
            // number of valid choices to put (P1, D1) = L * (L - 1) / 2
            //
            // (L - 2) slots to put (P2, D2)
            // number of valid choices to put (P2, D2) = L' * (L' - 1) / 2
            // ...
            // 2 slots to put (PN, DN)
            // number of valid choices to put (PN, DN) = 2 * (2 - 1) / 2 = 1
            //
            // total number of valid choices = choices1 * choices2 * ... * choicesN
            int slots = 2 * n;

            long count = 1;
            while (slots > 0) {
                int choices = slots * (slots - 1) / 2;
                count *= choices;
                count %= MOD;
                slots -= 2;
            }
            return (int) count;
        }
    }
}
