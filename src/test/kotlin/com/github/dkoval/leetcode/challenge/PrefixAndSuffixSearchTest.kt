package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PrefixAndSuffixSearchTest {

    @Test
    fun `should verify solution`() {
        val wordFilter = PrefixAndSuffixSearch.WordFilter(arrayOf("apple"))
        val actual = wordFilter.f("a", "e")
        // expect 0, because the word at index 0 has prefix = "a" and suffix = "e"
        assertEquals(0, actual)
    }
}