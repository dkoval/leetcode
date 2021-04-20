package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3714/">N-ary Tree Preorder Traversal</a>
 * <p>
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 104]</li>
 *  <li>0 <= Node.val <= 104</li>
 *  <li>The height of the n-ary tree is less than or equal to 1000</li>
 * </ul>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
interface NaryTreePreorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    List<Integer> preorder(Node root);

    class NaryTreePreorderTraversalRecursive implements NaryTreePreorderTraversal {

        @Override
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;
        }

        private void preorder(Node root, List<Integer> result) {
            if (root == null) {
                return;
            }

            result.add(root.val);

            if (root.children == null) {
                return;
            }

            for (Node child : root.children) {
                preorder(child, result);
            }
        }
    }
}
