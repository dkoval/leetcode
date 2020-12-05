package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3555/">Can Place Flowers</a>
 * <p>
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 */
public class CanPlaceFlowers {

    // O(N) time | O(1) space
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int numPlantedFlowers = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i > 0) ? flowerbed[i - 1] : 0;
                int next = (i < flowerbed.length - 1) ? flowerbed[i + 1] : 0;
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    numPlantedFlowers++;
                }
            }
            if (numPlantedFlowers >= n) {
                return true;
            }
        }
        return false;
    }
}
