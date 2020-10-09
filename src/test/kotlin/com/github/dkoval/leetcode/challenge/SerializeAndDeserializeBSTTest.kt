package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SerializeAndDeserializeBSTTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                null
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                }
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                }
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2)
                }
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(1).apply {
                            right = TreeNode(2)
                        }
                        right = TreeNode(4)
                    }
                    right = TreeNode(9).apply {
                        left = TreeNode(7).apply {
                            left = TreeNode(6)
                            right = TreeNode(8)
                        }
                        right = TreeNode(10)
                    }
                }
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should serialize and deserialize BST`(root: TreeNode?) {
        val data = SerializeAndDeserializeBST.CODEC.serialize(root)
        val actual = SerializeAndDeserializeBST.CODEC.deserialize(data)
        assertTrue(actual.equalsTo(root))
    }
}