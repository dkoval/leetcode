package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/delete-characters-to-make-fancy-string/">Delete Characters to Make Fancy String</a>
 * <p>
 * A fancy string is a string where no three consecutive characters are equal.
 * <p>
 * Given a string s, delete the minimum possible number of characters from s to make it fancy.
 * <p>
 * Return the final string after the deletion. It can be shown that the answer will always be unique.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists only of lowercase English letters.</li>
 * </ul>
 */
public interface DeleteCharactersToMakeFancyString {

    String makeFancyString(String s);

    class DeleteCharactersToMakeFancyStringRev1 implements DeleteCharactersToMakeFancyString {

        @Override
        public String makeFancyString(String s) {
            int n = s.length();

            if (n < 3) {
                return s;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == c && sb.charAt(sb.length() - 2) == c) {
                    continue;
                }
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
