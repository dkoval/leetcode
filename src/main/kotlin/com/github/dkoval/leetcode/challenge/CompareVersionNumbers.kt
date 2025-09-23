package com.github.dkoval.leetcode.challenge

object CompareVersionNumbersRev1 : CompareVersionNumbers {

    override fun compareVersion(version1: String, version2: String): Int {
        val tokens1 = version1.split(".")
        val tokens2 = version2.split(".")
        val maxLength = maxOf(tokens1.size, tokens2.size)
        for (i in 0 until maxLength) {
            val rev1 = if (i < tokens1.size) tokens1[i].toInt() else 0
            val rev2 = if (i < tokens2.size) tokens2[i].toInt() else 0
            if (rev1 != rev2) {
                return if (rev1 < rev2) -1 else 1
            }
        }
        return 0
    }
}