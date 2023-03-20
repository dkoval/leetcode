package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/can-place-flowers/">Can Place Flowers</a>
 * <p>
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= flowerbed.length <= 2 * 10^4</li>
 *  <li>flowerbed[i] is 0 or 1.</li>
 *  <li>There are no two adjacent flowers in flowerbed.</li>
 *  <li>0 <= n <= flowerbed.length</li>
 * </ul>
 */
public class CanPlaceFlowers {

    // O(N) time | O(1) space
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        for (int i = 0; i < size && n > 0; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i > 0) ? flowerbed[i - 1] : 0;
                int next = (i + 1 < size) ? flowerbed[i + 1] : 0;
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n == 0;
    }
}
