package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/clone-graph/">Clone Graph</a>
 * <p>
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the graph is in the range [0, 100].</li>
 *  <li>1 <= Node.val <= 100</li>
 *  <li>Node.val is unique for each node.</li>
 *  <li>There are no repeated edges and no self-loops in the graph.</li>
 *  <li>The Graph is connected and all nodes can be visited starting from the given node.</li>
 * </ul>
 */
public interface CloneGraph {

    Node cloneGraph(Node node);

    class Node {
        public final int val;
        public final List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    class CloneGraphDFS implements CloneGraph {

        @Override
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            // `visited` map holds (original node -> cloned node) mapping
            return dfs(node, new HashMap<>());
        }

        private Node dfs(Node node, Map<Node, Node> visited) {
            // has `node` already been cloned?
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            Node copyOfNode = new Node(node.val);
            visited.put(node, copyOfNode);
            for (Node neighbor : node.neighbors) {
                // recursively clone all neighbors of the current node
                Node copyOfNeighbor = dfs(neighbor, visited);
                copyOfNode.neighbors.add(copyOfNeighbor);
            }
            return copyOfNode;
        }
    }

    class CloneGraphBFS implements CloneGraph {

        @Override
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            // BFS
            Queue<Node> q = new ArrayDeque<>();
            Map<Node, Node> visited = new HashMap<>();

            Node cloneOfNode = new Node(node.val);
            q.offer(node);
            visited.put(node, cloneOfNode);
            while (!q.isEmpty()) {
                Node curr = q.poll();
                Node cloneOfCurr = visited.get(curr);
                for (Node neighbor : curr.neighbors) {
                    Node cloneOfNeighbor = visited.containsKey(neighbor)
                            ? visited.get(neighbor)
                            : new Node(neighbor.val);

                    cloneOfCurr.neighbors.add(cloneOfNeighbor);

                    if (!visited.containsKey(neighbor)) {
                        q.offer(neighbor);
                        visited.put(neighbor, cloneOfNeighbor);
                    }
                }
            }
            return cloneOfNode;
        }
    }
}
