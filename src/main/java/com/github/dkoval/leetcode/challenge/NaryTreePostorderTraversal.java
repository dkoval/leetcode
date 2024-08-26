package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">N-ary Tree Postorder Traversal</a>
 * <p>
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by
 * the null value.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 10^4].</li>
 *  <li>0 <= Node.val <= 10^4</li>
 *  <li>The height of the n-ary tree is less than or equal to 1000.</li>
 * </ul>
 */
public interface NaryTreePostorderTraversal {

    List<Integer> postorder(Node root);

    record Node(int val, List<Node> children) {
    }

    class NaryTreePostorderTraversalRev1 implements NaryTreePostorderTraversal {

        @Override
        public List<Integer> postorder(Node root) {
            List<Integer> ans = new ArrayList<>();
            traverse(root, ans);
            return ans;
        }

        private void traverse(Node node, List<Integer> ans) {
            if (node == null) {
                return;
            }

            // visit child nodes first
            for (Node child : node.children) {
                traverse(child, ans);
            }
            // process the current node
            ans.add(node.val);
        }
    }
}
