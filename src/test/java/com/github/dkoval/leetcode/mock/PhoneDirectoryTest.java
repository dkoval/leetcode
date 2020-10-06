package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDirectoryTest {

    @Test
    public void smokeTest() {
        PhoneDirectory directory = new PhoneDirectory(3);
        assertEquals(0, directory.get());
        assertEquals(1, directory.get());
        assertTrue(directory.check(2));
        assertEquals(2, directory.get());
        assertFalse(directory.check(2));

        directory.release(2);
        assertTrue(directory.check(2));
    }
}