package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-units-on-a-truck/">Maximum Units on a Truck</a>
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
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= boxTypes.length <= 1000</li>
 *  <li>1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000</li>
 *  <li>1 <= truckSize <= 10</li>
 * </ul>
 */
public class MaximumUnitsOnTruck {

    // O(NlogN) time | O(1) space
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // sort by numberOfUnitsPerBox in desc order
        Arrays.sort(boxTypes, (boxType1, boxType2) -> boxType2[1] - boxType1[1]);

        int totalNumUnits = 0;
        int capacity = truckSize;
        for (int[] boxType : boxTypes) {
            int numBoxesCanTake = Math.min(boxType[0], capacity);
            totalNumUnits += numBoxesCanTake * boxType[1];
            capacity -= numBoxesCanTake;
            if (capacity == 0) {
                break;
            }
        }
        return totalNumUnits;
    }
}
