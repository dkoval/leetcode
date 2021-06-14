package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3778/">Maximum Units on a Truck</a>
 * <p>
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes,
 * where boxTypes[i] = [numberOfBoxes_i, numberOfUnitsPerBox_i]:
 * <ul>
 *  <li>numberOfBoxes_i is the number of boxes of type i.</li>
 *  <li>numberOfUnitsPerBox_i is the number of units in each box of the type i.</li>
 * </ul>
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
 * You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 * <p>
 * Return the maximum total number of units that can be put on the truck.
 */
public class MaximumUnitsOnTruck {

    // O(NlogN) time | O(1) space
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (boxType1, boxType2) -> boxType2[1] - boxType1[1]);
        int capacity = truckSize;
        int totalNumUnits = 0;
        for (int[] boxType : boxTypes) {
            if (capacity > 0) {
                totalNumUnits += Math.min(boxType[0], capacity) * boxType[1];
                capacity -= boxType[0];
            } else {
                break;
            }
        }
        return totalNumUnits;
    }
}
