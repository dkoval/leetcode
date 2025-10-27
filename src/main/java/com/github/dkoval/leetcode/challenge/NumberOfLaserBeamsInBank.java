package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/number-of-laser-beams-in-a-bank/">Number of Laser Beams in a Bank</a>
 * <p>
 * Anti-theft security devices are activated inside a bank.
 * You are given a 0-indexed binary string array bank representing the floor plan of the bank,
 * which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's.
 * '0' means the cell is empty, while'1' means the cell has a security device.
 * <p>
 * There is one laser beam between any two security devices if both conditions are met:
 * <ul>
 *  <li>The two devices are located on two different rows: r1 and r2, where r1 < r2.</li>
 *  <li>For each row i where r1 < i < r2, there are no security devices in the ith row.</li>
 * </ul>
 * Laser beams are independent, i.e., one beam does not interfere nor join with another.
 * <p>
 * Return the total number of laser beams in the bank.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == bank.length</li>
 *  <li>n == bank[i].length</li>
 *  <li>1 <= m, n <= 500</li>
 *  <li>bank[i][j] is either '0' or '1'</li>
 * </ul>
 */
public interface NumberOfLaserBeamsInBank {

    int numberOfBeams(String[] bank);

    // O(M * N) time | O(1) space
    class NumberOfLaserBeamsInBankRev1 implements NumberOfLaserBeamsInBank {

        @Override
        public int numberOfBeams(String[] bank) {
            int n = bank[0].length();

            int total = 0;
            int prev = 0;
            for (String row : bank) {
                // the number of security devices on the current row
                int curr = 0;
                for (int i = 0; i < n; i++) {
                    if (row.charAt(i) == '1') {
                        curr++;
                    }
                }

                if (curr != 0) {
                    total += prev * curr;
                    prev = curr;
                }
            }
            return total;
        }
    }

    class NumberOfLaserBeamsInBankRev2 implements NumberOfLaserBeamsInBank {

        @Override
        public int numberOfBeams(String[] bank) {
            final var n = bank.length;

            // count the number of devices on each row
            final var devices = new ArrayList<Integer>();
            for (var row : bank) {
                var count = 0;
                for (var col = 0; col < row.length(); col++) {
                    if (row.charAt(col) == '1') {
                        count++;
                    }
                }

                // skip rows with no devices
                if (count > 0) {
                    devices.add(count);
                }
            }

            var total = 0;
            for (var i = 0; i < devices.size() - 1; i++) {
                total += devices.get(i) * devices.get(i + 1);
            }
            return total;
        }
    }
}
