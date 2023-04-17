package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">Kids With the Greatest Number of Candies</a>
 * <p>
 * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies
 * the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
 * <p>
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
 * they will have the greatest number of candies among all the kids, or false otherwise.
 * <p>
 * Note that multiple kids can have the greatest number of candies.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == candies.length</li>
 *  <li>2 <= n <= 100</li>
 *  <li>1 <= candies[i] <= 100</li>
 *  <li>1 <= extraCandies <= 50</li>
 * </ul>
 */
public interface KidsWithGreatestNumberOfCandies {

    List<Boolean> kidsWithCandies(int[] candies, int extraCandies);

    // O(N) time | O(1) extra space
    class KidsWithGreatestNumberOfCandiesRev1 implements KidsWithGreatestNumberOfCandies {

        @Override
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int n = candies.length;

            int max = 0;
            for (int x : candies) {
                max = Math.max(max, x);
            }

            List<Boolean> ans = new ArrayList<>();
            for (int x : candies) {
                ans.add(x + extraCandies >= max);
            }
            return ans;
        }
    }
}
