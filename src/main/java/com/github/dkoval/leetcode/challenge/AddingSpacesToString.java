package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/adding-spaces-to-a-string/">Adding Spaces to a String</a>
 * <p>
 * You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original
 * string where spaces will be added. Each space should be inserted before the character at the given index.
 * <p>
 * For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C', which are
 * at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
 * <p>
 * Return the modified string after the spaces have been added.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 3 * 10^5</li>
 *  <li>s consists only of lowercase and uppercase English letters.</li>
 *  <li>1 <= spaces.length <= 3 * 10^5</li>
 *  <li>0 <= spaces[i] <= s.length - 1</li>
 *  <li>All the values of spaces are strictly increasing.</li>
 * </ul>
 */
public interface AddingSpacesToString {

    String addSpaces(String s, int[] spaces);

    class AddingSpacesToStringRev1 implements AddingSpacesToString {

        @Override
        public String addSpaces(String s, int[] spaces) {
            var index = 0;
            var sb = new StringBuilder();
            for (var i = 0; i < s.length(); i++) {
                if (index < spaces.length && i == spaces[index]) {
                    sb.append(' ');
                    index++;
                }
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}
