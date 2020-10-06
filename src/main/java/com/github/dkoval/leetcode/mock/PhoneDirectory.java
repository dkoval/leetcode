package com.github.dkoval.leetcode.mock;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/design-phone-directory/">Design Phone Directory</a>
 *
 * Design a Phone Directory which supports the following operations:
 *
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 */
public class PhoneDirectory {
    private final Set<Integer> occupied = new LinkedHashSet<>();
    private final Set<Integer> released = new LinkedHashSet<>();
    private final int maxNumbers;
    private int lastAssignedNumber = -1;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (released.isEmpty() && lastAssignedNumber == maxNumbers - 1) {
            return -1;
        }
        if (!released.isEmpty()) {
            Iterator<Integer> it = released.iterator();
            int number = it.next();
            it.remove();
            return number;
        }
        int number = ++lastAssignedNumber;
        occupied.add(number);
        return number;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !occupied.contains(number) || released.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number <= lastAssignedNumber) {
            released.add(number);
        }
    }
}