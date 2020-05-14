package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TrieTest {

    @Test
    fun `should pass public contract check`() {
        val trie = Trie()

        trie.insert("apple")
        assertTrue(trie.search("apple"))

        assertFalse(trie.search("app"))
        assertTrue(trie.startsWith("app"))

        trie.insert("app")
        assertTrue(trie.search("app"))
    }
}