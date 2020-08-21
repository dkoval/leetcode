package com.github.dkoval.leetcode.interview.strings

/**
 * [Implement strStr()](https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/885/)
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 * - What should we return when needle is an empty string? This is a great question to ask during an interview.
 * - For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's [strstr()](http://www.cplusplus.com/reference/cstring/strstr/)
 * and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)).
 */
object ImplementStrStr {

    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        for (i in 0..haystack.length - needle.length) { // sliding window of size needle.length
            var found = true
            for (j in i until i + needle.length) {
                if (haystack[j] != needle[j - i]) {
                    found = false
                    break
                }
            }
            if (found) return i
        }
        return -1
    }
}