package com.github.dkoval.leetcode.challenge

/**
 * [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the `WordDictionary` class:
 *
 * - `WordDictionary()` Initializes the object.
 * - `void addWord(word)` Adds `word` to the data structure, it can be matched later.
 * - `bool search(word)` Returns `true` if there is any string in the data structure that matches `word` or `false` otherwise.
 * `word` may contain dots `'.'` where dots can be matched with any letter.
 *
 * Constraints:
 *
 * - 1 <= word.length <= 25
 * - `word` in `addWord` consists of lowercase English letters.
 * - `word` in search consist of `'.'` or lowercase English letters.
 * - There will be at most 3 dots in `word` for `search` queries.
 * - At most 10^4 calls will be made to `addWord` and `search`.
 */
class WordDictionary {

    private class TrieNode {
        val branches = mutableMapOf<Char, TrieNode>()
        var isWord = false
    }

    private val root = TrieNode()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        var curr = root
        for (c in word) {
            curr = curr.branches.getOrPut(c) { TrieNode() }
        }
        curr.isWord = true
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean = doSearch(word, 0, root)

    private fun doSearch(word: String, start: Int, node: TrieNode): Boolean {
        var curr = node
        for (i in start until word.length) {
            val c = word[i]
            if (c == '.') {
                for ((_, next) in curr.branches) {
                    if (doSearch(word, i + 1, next)) {
                        return true
                    }
                }
                return false
            }
            curr = curr.branches[c] ?: return false
        }
        return curr.isWord
    }
}