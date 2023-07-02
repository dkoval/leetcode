package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/fair-distribution-of-cookies/">Fair Distribution of Cookies</a>
 * <p>
 * You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag.
 * You are also given an integer k that denotes the number of children to distribute all the bags of cookies to.
 * All the cookies in the same bag must go to the same child and cannot be split up.
 * <p>
 * The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
 * <p>
 * Return the minimum unfairness of all distributions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= cookies.length <= 8</li>
 *  <li>1 <= cookies[i] <= 10^5</li>
 *  <li>2 <= k <= cookies.length</li>
 * </ul>
 */
public interface FairDistributionOfCookies {

    int distributeCookies(int[] cookies, int k);

    class FairDistributionOfCookiesRev1 implements FairDistributionOfCookies {

        @Override
        public int distributeCookies(int[] cookies, int k) {
            return calculate(cookies, 0, new int[k]);
        }

        private int calculate(int[] cookies, int i, int[] children) {
            int n = cookies.length;
            int k = children.length;

            if (i >= n) {
                int max = Integer.MIN_VALUE;
                for (int x : children) {
                    max = Math.max(max, x);
                }
                return max;
            }

            int best = Integer.MAX_VALUE;
            for (int c = 0; c < k; c++) {
                // give cookies in the i-th bag to the c-th child
                children[c] += cookies[i];
                // proceed to the (i + 1)-th bag
                best = Math.min(best, calculate(cookies, i + 1, children));
                // backtrack
                children[c] -= cookies[i];
            }
            return best;
        }
    }
}
