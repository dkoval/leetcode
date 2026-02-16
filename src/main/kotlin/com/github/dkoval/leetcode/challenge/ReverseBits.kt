package com.github.dkoval.leetcode.challenge

object ReverseBitsBitByBit: ReverseBits {

    override fun reverseBits(n: Int): Int {
        var result = 0
        var bits = n
        var pos = 31
        while (bits != 0) {
            val bit = bits and 1
            result = result or (bit shl pos)
            bits = bits ushr 1
            pos--
        }
        return result
    }
}

object ReverseBitsMaskAndShift: ReverseBits {

    override fun reverseBits(n: Int): Int {
        var result = (n ushr 16) or (n shl 16)
        result = ((result and 0xff00ff00.toInt()) ushr 8) or ((result and 0x00ff00ff) shl 8)
        result = ((result and 0xf0f0f0f0.toInt()) ushr 4) or ((result and 0x0f0f0f0f) shl 4)
        result = ((result and 0xcccccccc.toInt()) ushr 2) or ((result and 0x33333333) shl 2)
        result = ((result and 0xaaaaaaaa.toInt()) ushr 1) or ((result and 0x55555555) shl 1)
        return result
    }
}
