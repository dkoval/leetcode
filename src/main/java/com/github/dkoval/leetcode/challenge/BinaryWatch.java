package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-watch/">Binary Watch</a>
 * <p>
 * A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
 * <p>
 * The hour must not contain a leading zero.
 * <p>
 * For example, "01:00" is not valid. It should be "1:00".
 * <p>
 * The minute must consist of two digits and may contain a leading zero.
 * <p>
 * For example, "10:2" is not valid. It should be "10:02".
 * <p>
 * Constraints:
 * <p>
 * 0 <= turnedOn <= 10
 */
public interface BinaryWatch {

    List<String> readBinaryWatch(int turnedOn);

    class BinaryWatchRev1 implements BinaryWatch {

        @Override
        public List<String> readBinaryWatch(int turnedOn) {
            final var res = new ArrayList<String>();
            // consider all possible hh:mm combinations
            for (var hour = 0; hour < 12; hour++) {
                for (var minute = 0; minute < 60; minute++) {
                    if (countBits(hour) + countBits(minute) == turnedOn) {
                        res.add(formatTime(hour, minute));
                    }
                }
            }
            return res;
        }

        private int countBits(int x) {
            var count = 0;
            while (x > 0) {
                count += x & 1;
                x >>= 1;
            }
            return count;
        }

        private String formatTime(int hour, int minute) {
            return String.format("%d:%02d", hour, minute);
        }
    }
}
