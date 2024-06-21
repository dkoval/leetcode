package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/grumpy-bookstore-owner/">Grumpy Bookstore Owner</a>
 * <p>
 * There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store.
 * You are given an integer array customers of length n where customers[i] is the number of the customer that enters the
 * store at the start of the ith minute and all those customers leave after the end of that minute.
 * <p>
 * On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1
 * if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
 * <p>
 * When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
 * <p>
 * The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes,
 * but can only use it once.
 * <p>
 * Return the maximum number of customers that can be satisfied throughout the day.
 * <p>
 * Constraints:
 * <ul>
 *  <li>>n == customers.length == grumpy.length</li>
 *  <li>>1 <= minutes <= n <= 2 * 10^4</li>
 *  <li>>0 <= customers[i] <= 1000</li>
 *  <li>>grumpy[i] is either 0 or 1</li>
 * </ul>
 */
public interface GrumpyBookstoreOwner {

    int maxSatisfied(int[] customers, int[] grumpy, int minutes);

    class GrumpyBookstoreOwnerRev1 implements GrumpyBookstoreOwner {

        @Override
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;

            int total = 0;
            for (int i = 0; i < n; i++) {
                if (grumpy[i] == 0) {
                    total += customers[i];
                }
            }

            // sliding window
            // 0, 1, ... k - 1, k, ..., n - 1
            // <-------------> 1st window
            //    <-------------> 2nd window
            int maxDelta = 0;
            for (int start = 0; start <= n - minutes; start++) {
                //  bookstore owner is not grumpy for k consecutive minutes
                int delta = 0;
                for (int i = start; i < start + minutes; i++) {
                    if (grumpy[i] == 1) {
                        delta += customers[i];
                    }
                }
                maxDelta = Math.max(maxDelta, delta);
            }
            return total + maxDelta;
        }
    }

    class GrumpyBookstoreOwnerRev2 implements GrumpyBookstoreOwner {

        @Override
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;

            int total = 0;
            for (int i = 0; i < n; i++) {
                if (grumpy[i] == 0) {
                    total += customers[i];
                }
            }

            // sliding window
            // 0, 1, ... k - 1, k, ..., n - 1
            // <-------------> 1st window
            //    <-------------> 2nd window
            int delta = 0;
            int maxDelta = 0;
            for (int end = 0; end < n; end++) {
                if (grumpy[end] == 1) {
                    delta += customers[end];
                }
                //  bookstore owner is not grumpy for k consecutive minutes
                if (end >= minutes && grumpy[end - minutes] == 1) {
                    // exclude the 1st element of previous window
                    delta -= customers[end - minutes];
                }
                maxDelta = Math.max(maxDelta, delta);
            }
            return total + maxDelta;
        }
    }

    class GrumpyBookstoreOwnerRev3 implements GrumpyBookstoreOwner {

        @Override
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;

            // sliding window
            // 0, 1, ... k - 1, k, ..., n - 1
            // <-------------> 1st window
            //    <-------------> 2nd window
            int total = 0;
            int maxDelta = 0;
            int delta = 0;
            for (int i = 0; i < n; i++) {
                if (grumpy[i] == 0) {
                    total += customers[i];
                } else {
                    delta += customers[i];
                }

                //  bookstore owner is not grumpy for k consecutive minutes
                if (i >= minutes && grumpy[i - minutes] == 1) {
                    // exclude the 1st element of previous window
                    delta -= customers[i - minutes];
                }
                maxDelta = Math.max(maxDelta, delta);
            }
            return total + maxDelta;
        }
    }
}
