package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/get-equal-substrings-within-budget/">Get Equal Substrings Within Budget</a>
 * <p>
 * You are given two strings s and t of the same length and an integer maxCost.
 * <p>
 * You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]|
 * (i.e., the absolute difference between the ASCII values of the characters).
 * <p>
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t
 * with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding
 * substring from t, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>t.length == s.length</li>
 *  <li>0 <= maxCost <= 10^6</li>
 *  <li>s and t consist of only lowercase English letters</li>
 * </ul>
 */
public interface GetEqualSubstringsWithinBudget {

    int equalSubstring(String s, String t, int maxCost);

    class GetEqualSubstringsWithinBudgetRev1 implements GetEqualSubstringsWithinBudget {

        @Override
        public int equalSubstring(String s, String t, int maxCost) {
            // s and t are of the same length
            int n = s.length();

            // sliding window
            int best = 0;
            int currCost = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                currCost += cost(s, t, right);
                while (currCost > maxCost) {
                    // shrink the window from the left until it becomes valid again
                    currCost -= cost(s, t, left);
                    left++;
                }
                best = Math.max(best, right - left + 1);
            }
            return best;
        }

        private int cost(String s, String t, int index) {
            return Math.abs(s.charAt(index) - t.charAt(index));
        }
    }
}
