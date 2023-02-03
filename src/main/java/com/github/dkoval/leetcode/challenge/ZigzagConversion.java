package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/">Zigzag Conversion</a>
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>s consists of English letters (lower-case and upper-case), ',' and '.'.</li>
 *  <li>1 <= numRows <= 1000</li>
 * </ul>
 */
public interface ZigzagConversion {

    String convert(String s, int numRows);

    // O(N) time | O(N) space
    class ZigzagConversionRev1 implements ZigzagConversion {

        @Override
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }

            StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                rows[i] = new StringBuilder();
            }

            int n = s.length();
            int[][] zigzags = {
                    // range(start, stop, step)
                    {0, numRows, 1},     // down
                    {numRows - 2, 0, -1} // up
            };

            int i = 0;
            int k = 0;
            while (i < n) {
                int r = zigzags[k][0];
                while (i < n && r != zigzags[k][1]) {
                    rows[r].append(s.charAt(i));
                    i++;
                    r += zigzags[k][2];
                }
                k = (k + 1) % 2;
            }

            StringBuilder ans = new StringBuilder();
            for (StringBuilder row : rows) {
                ans.append(row);
            }
            return ans.toString();
        }
    }
}
