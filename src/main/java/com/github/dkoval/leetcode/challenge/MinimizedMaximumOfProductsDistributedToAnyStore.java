package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/">Minimized Maximum of Products Distributed to Any Store</a>
 * <p>
 * You are given an integer n indicating there are n specialty retail stores.
 * There are m product types of varying amounts, which are given as a 0-indexed integer array quantities,
 * where quantities[i] represents the number of products of the ith product type.
 * <p>
 * You need to distribute all products to the retail stores following these rules:
 * <ul>
 *  <li>A store can only be given at most one product type but can be given any amount of it.</li>
 *  <li>After distribution, each store will have been given some number of products (possibly 0).
 *  Let x represent the maximum number of products given to any store. You want x to be as small as possible, i.e.,
 *  you want to minimize the maximum number of products that are given to any store.
 *  </li>
 * </ul>
 * Return the minimum possible x.
 */
public interface MinimizedMaximumOfProductsDistributedToAnyStore {

    int minimizedMaximum(int n, int[] quantities);

    class MinimizedMaximumOfProductsDistributedToAnyStoreRev1 implements MinimizedMaximumOfProductsDistributedToAnyStore {

        @Override
        public int minimizedMaximum(int n, int[] quantities) {
            // Idea: guess the answer x with binary search.
            // condition: can all products be distributed such that any store will be given <= x products?
            // FF...FTT...T
            //       ^ answer (min number that satisfies the condition)
            int max = 0;
            for (int x : quantities) {
                max = Math.max(max, x);
            }

            int left = 1;
            int right = max;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canDistribute(n, quantities, mid)) {
                    // mid may be the answer;
                    // check if there's a better alternative to the left of mid
                    right = mid;
                } else {
                    // mid can't be the answer
                    left = mid + 1;
                }
            }
            return left;
        }

        // Can all products be distributed such that any store will be given <= target products?
        private boolean canDistribute(int n, int[] quantities, int target) {
            for (int q : quantities) {
                // roundUp(x / y) = (x + y - 1) / y = (x - 1) / y + 1
                n -= (q - 1) / target + 1;
                if (n < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
