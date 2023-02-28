package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-duplicate-subtrees/">Find Duplicate Subtrees</a>
 * <p>
 * Given the root of a binary tree, return all duplicate subtrees.
 * <p>
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * <p>
 * Two trees are duplicate if they have the same structure with the same node values.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of the nodes in the tree will be in the range [1, 5000]</li>
 *  <li>-200 <= Node.val <= 200</li>
 * </ul>
 */
public interface FindDuplicateSubtrees {

    List<TreeNode> findDuplicateSubtrees(TreeNode root);

    class FindDuplicateSubtreesRev1 implements FindDuplicateSubtrees {

        @Override
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            // idea: serialize a binary tree to get its unique "signature"
            Map<String, List<TreeNode>> seen = new HashMap<>();
            List<TreeNode> ans = new ArrayList<>();
            preorder(root, seen, ans);
            return ans;
        }

        private String preorder(TreeNode root, Map<String, List<TreeNode>> seen, List<TreeNode> ans) {
            if (root == null) {
                return "null";
            }

            // ROOT, LEFT, RIGHT
            String sign = String.join(",", String.valueOf(root.val), preorder(root.left, seen, ans), preorder(root.right, seen, ans));

            List<TreeNode> subtrees = seen.computeIfAbsent(sign, __ -> new ArrayList<>());
            subtrees.add(root);
            if (subtrees.size() == 2) {
                ans.add(root);
            }
            return sign;
        }
    }
}
