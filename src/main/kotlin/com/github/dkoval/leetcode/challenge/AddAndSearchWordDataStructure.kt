package com.github.dkoval.leetcode.challenge

/**
 * [Add and Search Word - Data structure design](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/)
 *
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 *
 * search(word) can search a literal word or a regular expression string containing only letters `a-z` or `.`.
 * A `.` means it can represent any one letter.
 */
class WordDictionary {

    private class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var endOfWord = false
    }

    private val root = TrieNode()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        var curr = root
        for (c in word) {
            curr = curr.children.getOrPut(c) { TrieNode() }
        }
        curr.endOfWord = true
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean = doSearch(root, word, 0)

    private fun doSearch(root: TrieNode, word: String, start: Int): Boolean {
        var curr = root
        for (i in start until word.length) {
            val c = word[i]
            if (c == '.') {
                for ((_, next) in curr.children) {
                    val found = doSearch(next, word, i + 1)
                    if (found) {
                        return true
                    }
                }
                return false
            }
            curr = curr.children[c] ?: return false
        }
        return curr.endOfWord
    }
}