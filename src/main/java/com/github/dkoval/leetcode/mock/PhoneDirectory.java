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
    private final int maxNumbers;
    private final Set<Integer> releasedNumbers = new LinkedHashSet<>();
    private int nextNumber = 0;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!releasedNumbers.isEmpty()) {
            Iterator<Integer> it = releasedNumbers.iterator();
            int releasedNumber = it.next();
            it.remove();
            return releasedNumber;
        }
        if (nextNumber < maxNumbers) {
            return nextNumber++;
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return releasedNumbers.contains(number) || (number >= nextNumber && number < maxNumbers);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number < nextNumber) {
            releasedNumbers.add(number);
        }
    }
}