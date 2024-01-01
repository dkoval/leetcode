package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/assign-cookies/">Assign Cookies</a>
 * <p>
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 * <p>
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= g.length <= 3 * 10^4</li>
 *  <li>0 <= s.length <= 3 * 10^4</li>
 *  <li>1 <= g[i], s[j] <= 2^31 - 1</li>
 * </ul>
 */
public interface AssignCookies {

    int findContentChildren(int[] g, int[] s);

    class AssignCookiesRev1 implements AssignCookies {

        @Override
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int count = 0;
            int j = 0;
            for (int greedFactor : g) {
                while (j < s.length && s[j] < greedFactor) {
                    // s[j] is too small, try another one
                    j++;
                }

                if (j == s.length) {
                    break;
                }

                count++;
                j++;
            }
            return count;
        }
    }
}
