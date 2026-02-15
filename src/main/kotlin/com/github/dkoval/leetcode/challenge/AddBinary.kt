package com.github.dkoval.leetcode.challenge

import kotlin.math.max

object AddBinaryRev1 : AddBinary {

    override fun addBinary(a: String, b: String): String {
        val result = StringBuilder()
        var carry = 0
        for (i in 0 until max(a.length, b.length)) {
            val digitOfA = if (i < a.length) a[a.lastIndex - i] - '0' else 0
            val digitOfB = if (i < b.length) b[b.lastIndex - i] - '0' else 0
            val sum = digitOfA + digitOfB + carry
            val digit = sum % 2
            carry = sum / 2
            result.append(digit)
        }
        if (carry == 1) {
            result.append(1)
        }
        return result.reverse().toString()
    }
}