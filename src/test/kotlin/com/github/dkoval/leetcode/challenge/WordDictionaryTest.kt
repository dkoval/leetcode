package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class WordDictionaryTest {

    @Test
    fun `should verify implementation`() {
        val dict = WordDictionary().apply {
            addWord("bad")
            addWord("dad")
            addWord("mad")
        }

        assertFalse(dict.search("pad"))
        assertTrue(dict.search("bad"))
        assertTrue(dict.search(".ad"))
        assertTrue(dict.search("b.."))
    }
}