package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3965/">Slowest Key</a>
 * <p>
 * A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.
 * <p>
 * You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed in the testing sequence,
 * and a sorted list releaseTimes, where releaseTimes[i] was the time the ith key was released.
 * Both arrays are 0-indexed. The 0th key was pressed at the time 0, and every subsequent key was pressed at the exact
 * time the previous key was released.
 * <p>
 * The tester wants to know the key of the keypress that had the longest duration. The ith keypress had a duration of
 * releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress had a duration of releaseTimes[0].
 * <p>
 * Note that the same key could have been pressed multiple times during the test, and these multiple presses of the same key
 * may not have had the same duration.
 * <p>
 * Return the key of the keypress that had the longest duration. If there are multiple such keypresses,
 * return the lexicographically largest key of the keypresses.
 */
public class SlowestKey {

    // O(N) time | O(1) space
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = keysPressed.length();
        int idx = 0;
        int longest = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            if ((duration > longest) || (duration == longest && keysPressed.charAt(i) > keysPressed.charAt(idx))) {
                longest = duration;
                idx = i;
            }
        }
        return keysPressed.charAt(idx);
    }
}
