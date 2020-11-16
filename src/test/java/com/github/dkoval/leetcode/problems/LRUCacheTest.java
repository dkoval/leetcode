package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.problems.LRUCache.LRUCacheUsingLinkedHashMap;
import com.github.dkoval.leetcode.problems.LRUCache.LRUCacheUsingSinglyLinkedList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {

    @Nested
    class LRUCacheUsingSinglyLinkedListTest {

        @Test
        public void smokeTestImplementation() {
            test(new LRUCacheUsingSinglyLinkedList(2));
        }
    }

    @Nested
    class LRUCacheUsingLinkedHashMapTest {

        @Test
        public void smokeTestImplementation() {
            test(new LRUCacheUsingLinkedHashMap(2));
        }
    }

    private static void test(LRUCache cache) {
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));

        cache.put(3, 3);
        assertEquals(-1, cache.get(2));

        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}