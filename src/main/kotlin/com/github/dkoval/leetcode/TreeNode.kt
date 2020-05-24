package com.github.dkoval.leetcode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
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