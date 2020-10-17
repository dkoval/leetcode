package com.github.dkoval.leetcode

interface ImmutableListNode {
    fun printValue()
    fun getNext(): ImmutableListNode?
}

data class DefaultImmutableListNode(
    private val value: Int,
    private val next: ImmutableListNode? = null
) : ImmutableListNode {

    override fun printValue() {
        val message = if (next != null) "$value," else "$value"
        print(message)
    }

    override fun getNext(): ImmutableListNode? = next
}