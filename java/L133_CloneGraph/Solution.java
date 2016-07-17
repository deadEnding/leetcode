package L133_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: deadend
 * @date: 4:27 PM 7/17/16
 * @version: 1.0
 * @description: Leetcode 133. Clone Graph
 */

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}


public class Solution {

    private UndirectedGraphNode dfsClone(UndirectedGraphNode node,
                                    Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap) {
        if (cloneMap.containsKey(node))
            return cloneMap.get(node);

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        cloneMap.put(node, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(dfsClone(neighbor, cloneMap));
        }
        return newNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<>();
        dfsClone(node, cloneMap);
        return cloneMap.get(node);
    }
}
