package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3501/">Clone Graph</a>
 *
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    public static class Node {
        public final int val;
        public final List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // `visited` map holds (original node -> copy of this node) mapping
        return doCloneGraph(node, new HashMap<>());
    }

    private Node doCloneGraph(Node node, Map<Node, Node> visited) {
        Node copyOfNode = new Node(node.val);
        visited.put(node, copyOfNode);
        for (Node neighbor : node.neighbors) {
            // if not visited, start DFS
            Node copyOfNeighbor = visited.containsKey(neighbor)
                    ? visited.get(neighbor)
                    : doCloneGraph(neighbor, visited);

            copyOfNode.neighbors.add(copyOfNeighbor);
        }
        return copyOfNode;
    }
}
