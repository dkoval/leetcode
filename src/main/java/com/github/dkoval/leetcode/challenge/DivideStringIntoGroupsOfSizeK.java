package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/">Divide a String Into Groups of Size k</a>
 * <p>
 * A string s can be partitioned into groups of size k using the following procedure:
 * <p>
 * The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on.
 * Each element can be a part of exactly one group.
 * <p>
 * For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
 * <p>
 * Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating
 * all the groups in order, the resultant string should be s.
 * <p>
 * Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group
 * s has been divided into, using the above procedure.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>s consists of lowercase English letters only.</li>
 *  <li>1 <= k <= 100</li>
 *  <li>fill is a lowercase English letter.</li>
 * </ul>
 */
public interface DivideStringIntoGroupsOfSizeK {

    String[] divideString(String s, int k, char fill);

    class DivideStringIntoGroupsOfSizeKRev1 implements DivideStringIntoGroupsOfSizeK {

        @Override
        public String[] divideString(String s, int k, char fill) {
            final var n = s.length();

            final var groups = (n - 1) / k + 1;
            final var ans = new String[groups];
            for (var g = 0; g < groups; g++) {
                final var sb = new StringBuilder();
                for (var i = g * k; i < Math.min(g * k + k, n); i++) {
                    sb.append(s.charAt(i));
                }

                while (sb.length() < k) {
                    sb.append(fill);
                }

                ans[g] = sb.toString();
            }
            return ans;
        }
    }
}
