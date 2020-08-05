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
        for (letter in word) {
            val node = curr.children.getOrPut(letter) { TrieNode() }
            curr = node
        }
        curr.endOfWord = true
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean = doSearch(word, 0, word.length, root)

    private fun doSearch(word: String, startIndexInclusive: Int, endIndexExclusive: Int, root: TrieNode): Boolean {
        var curr = root
        for (i in startIndexInclusive until endIndexExclusive) {
            val letter = word[i]
            if (letter == '.') {
                for ((_, node) in curr.children) {
                    if (doSearch(word, i + 1, endIndexExclusive, node)) return true
                }
                return false
            }
            val node = curr.children[letter] ?: return false
            curr = node
        }
        return curr.endOfWord
    }
}