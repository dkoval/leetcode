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
        if (node == null) return null;
        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, Map<Integer, Node> visited) {
        Node nodeCopy = new Node(node.val);
        visited.put(node.val, nodeCopy);
        for (Node neighbor : node.neighbors) {
            Node neighborCopy = visited.get(neighbor.val);
            if (neighborCopy == null) {
                // if not visited, start DFS
                neighborCopy = cloneGraph(neighbor, visited);
            }
            nodeCopy.neighbors.add(neighborCopy);
        }
        return nodeCopy;
    }
}
