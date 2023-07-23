package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/all-possible-full-binary-trees/">All Possible Full Binary Trees</a>
 * <p>
 * Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
 * <p>
 * Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
 * <p>
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 20</li>
 * </ul>
 */
public interface AllPossibleFullBinaryTrees {

    List<TreeNode> allPossibleFBT(int n);

    class AllPossibleFullBinaryTreesRev1 implements AllPossibleFullBinaryTrees {

        @Override
        public List<TreeNode> allPossibleFBT(int n) {
            return (n % 2 != 0) ? generate(n, new HashMap<>()) : Collections.emptyList();
        }

        private List<TreeNode> generate(int n, Map<Integer, List<TreeNode>> cache) {
            if (n == 1) {
                return Collections.singletonList(new TreeNode(0));
            }

            if (cache.containsKey(n)) {
                return cache.get(n);
            }

            List<TreeNode> ans = new ArrayList<>();
            // the total number of nodes in a valid full binary tree must be an odd number
            for (int numLeftNodes = 1; numLeftNodes < n; numLeftNodes += 2) {
                // n is odd
                // numLeftNodes is odd
                // (n - numLeftNodes - 1) is also odd
                int numRightNodes = n - numLeftNodes - 1;

                List<TreeNode> leftTrees = generate(numLeftNodes, cache);
                List<TreeNode> rightTrees = generate(numRightNodes, cache);

                // all possible combinations of (left, right) nodes
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        ans.add(new TreeNode(0, left, right));
                    }
                }
            }

            cache.put(n, ans);
            return ans;
        }
    }
}
