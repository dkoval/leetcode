package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode

/**
 * [Delete Node in a BST](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3443/)
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 * - Search for a node to remove.
 * - If the node is found, delete the node.
 *
 * Note: Time complexity should be O(height of tree).
 */
interface DeleteNodeInBST {

    fun deleteNode(root: TreeNode?, key: Int): TreeNode?
}

object DeleteNodeInBSTCaseByCase : DeleteNodeInBST {

    override fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        val (parent, node) = findNode(root, key)
        if (node == null) return root // key is not found in the tree
        var newRoot = root

        // case 1: node to be deleted has 2 children
        if (node.left != null && node.right != null) {
            val predecessor = findMaxNode(node.left!!)
            deleteNode(node, predecessor.`val`)
            node.`val` = predecessor.`val`
        }
        // case 2 & 3: node to be deleted has 0 or 1 child
        else {
            val child = node.left ?: node.right
            when {
                node == root -> newRoot = child
                parent!!.left == node -> parent.left = child
                else -> parent.right = child
            }
        }
        return newRoot
    }

    private fun findNode(root: TreeNode, key: Int): Pair<TreeNode?, TreeNode?> {
        var parent: TreeNode? = null
        var node: TreeNode? = root
        while (node != null && node.`val` != key) {
            parent = node
            node = if (key < node.`val`) {
                node.left
            } else {
                node.right
            }
        }
        return parent to node
    }

    private fun findMaxNode(root: TreeNode): TreeNode {
        var node = root
        while (node.right != null) {
            node = node.right!!
        }
        return node
    }
}

object DeleteNodeInBSTRecursive : DeleteNodeInBST {

    override fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        when {
            // find and delete key in the left subtree
            key < root.`val` -> root.left = deleteNode(root.left, key)
            // find and delete key in the right subtree
            key > root.`val` -> root.right = deleteNode(root.right, key)
            else -> {
                // delete current node
                if (root.left == null && root.right == null) {
                    // current node is a leaf node
                    return null
                } else if (root.left != null) {
                    // find inorder predecessor
                    root.`val` = findMaxNode(root.left!!).`val`
                    root.left = deleteNode(root.left, root.`val`)
                } else {
                    // find inorder successor
                    root.`val` = findMinNode(root.right!!).`val`
                    root.right = deleteNode(root.right, root.`val`)
                }
            }
        }
        return root
    }

    private fun findMinNode(root: TreeNode): TreeNode {
        var curr = root
        while (curr.left != null) {
            curr = curr.left!!
        }
        return curr
    }

    private fun findMaxNode(root: TreeNode): TreeNode {
        var curr = root
        while (curr.right != null) {
            curr = curr.right!!
        }
        return curr
    }
}