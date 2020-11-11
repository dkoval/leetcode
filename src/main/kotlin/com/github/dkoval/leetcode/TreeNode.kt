package com.github.dkoval.leetcode

@Suppress("EqualsOrHashCode")
class TreeNode(@JvmField var `val`: Int) {
    @JvmField
    var left: TreeNode? = null
    @JvmField
    var right: TreeNode? = null

    override fun equals(other: Any?): Boolean {
        return other is TreeNode && equalsTo(other)
    }
}

fun TreeNode?.equalsTo(that: TreeNode?): Boolean {
    if (this == null && that == null) {
        return true
    }
    if (this == null || that == null) {
        return false
    }
    return `val` == that.`val` && left.equalsTo(that.left) && right.equalsTo(that.right)
}