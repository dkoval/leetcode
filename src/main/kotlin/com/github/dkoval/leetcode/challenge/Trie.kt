package com.github.dkoval.leetcode.challenge

class Trie {

    private class Node {
        val children = mutableMapOf<Char, Node>()
        var endOfWord = false
    }

    private val root = Node()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var current = root
        for (ch in word) {
            val node = current.children.getOrPut(ch) { Node() }
            current = node
        }
        current.endOfWord = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean = doStartsWith(word)?.endOfWord ?: false

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean = doStartsWith(prefix) != null

    private fun doStartsWith(prefix: String): Node? {
        var current = root
        for (ch in prefix) {
            val node = current.children[ch] ?: return null
            current = node
        }
        return current
    }
}