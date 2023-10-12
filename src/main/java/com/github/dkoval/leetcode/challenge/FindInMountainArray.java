package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-in-mountain-array/">Find in Mountain Array (Hard)</a>
 * <p>
 * (This problem is an interactive problem.)
 * <p>
 * You may recall that an array arr is a mountain array if and only if:
 * <ul>
 *  <li>arr.length >= 3</li>
 *  <li>There exists some i with 0 < i < arr.length - 1 such that:</li>
 *      <ul>
 *          <li>arr[0] < arr[1] < ... < arr[i - 1] < arr[i]</li>
 *          <li>arr[i] > arr[i + 1] > ... > arr[arr.length - 1]</li>
 *      </ul>
 *  </li>
 * </ul>
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
 * If such an index does not exist, return -1.
 * <p>
 * You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
 * <p>
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= mountain_arr.length() <= 10^4</li>
 *  <li>0 <= target <= 10^9</li>
 *  <li>0 <= mountain_arr.get(index) <= 10^9</li>
 * </ul>
 */
public interface FindInMountainArray {

    int findInMountainArray(int target, MountainArray arr);

    class MountainArray {
        private final int[] arr;

        private MountainArray(int[] arr) {
            this.arr = arr;
        }

        public static MountainArray of(int[] arr) {
            return new MountainArray(arr);
        }

        public int get(int index) {
            return arr[index];
        }

        public int length() {
            return arr.length;
        }
    }

    class FindInMountainArrayRev1 implements FindInMountainArray {

        @Override
        public int findInMountainArray(int target, MountainArray arr) {
            int peekIndex = findPeek(arr);
            int index1 = find(target, arr, 0, peekIndex, true);
            int index2 = find(target, arr, peekIndex + 1, arr.length() - 1, false);

            if (index1 == -1 && index2 == -1) {
                return -1;
            }

            if (index1 == -1 || index2 == -1) {
                return Math.max(index1, index2);
            }

            return Math.min(index1, index2);
        }

        private int findPeek(MountainArray arr) {
            // binary search
            // arr.length() >= 3
            int left = 1;
            int right = arr.length() - 2;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int curr = arr.get(mid);
                int prev = arr.get(mid - 1);
                int next = arr.get(mid + 1);

                if (curr > prev && curr > next) {
                    return mid;
                }

                if (curr > prev && curr < next) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private int find(int target, MountainArray arr, int left, int right, boolean asc) {
            // binary search
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int curr = arr.get(mid);

                if (curr < target) {
                    if (asc) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (curr > target) {
                    if (asc) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
