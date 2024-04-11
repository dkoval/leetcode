package com.github.dkoval.leetcode.challenge

object RemoveKDigitsRev1 : RemoveKDigits  {

    override fun removeKdigits(num: String, k: Int): String {
        // 1 <= k <= num.length <= 10^5
        if (k == num.length) {
            return "0"
        }

        // if all digits are in increasing order, then delete last digit,
        // otherwise delete a digit for which next digit is smaller
        val sb = StringBuilder(num)
        repeat(k) {
            var i = 0
            while (i < sb.length - 1 && sb[i] <= sb[i + 1]) {
                i++
            }
            sb.deleteCharAt(i)
        }
        sb.removeLeadingZeros()
        return if (sb.isNotEmpty()) sb.toString() else "0"
    }

    private fun StringBuilder.removeLeadingZeros(): StringBuilder {
        while (isNotEmpty() && this[0] == '0') {
            deleteCharAt(0)
        }
        return this
    }
}