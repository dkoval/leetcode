package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3647/">Broken Calculator</a>
 * <p>
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 * <ul>
 *  <li>Double: Multiply the number on the display by 2, or;</li>
 *  <li>Decrement: Subtract 1 from the number on the display.</li>
 *  <li>Initially, the calculator is displaying the number X.</li>
 * </ul>
 * Return the minimum number of operations needed to display the number Y.
 */
public class BrokenCalculator {

    // O(logY) time | O(1) space
    public int brokenCalc(int X, int Y) {
        int numOps = 0;
        while (Y > X) {
            numOps++;
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
        }
        return numOps + (X - Y);
    }
}
