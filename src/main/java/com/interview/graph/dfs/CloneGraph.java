package com.interview.graph.dfs;

import com.interview.graph.others.CloneGraphNode;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {


    public CloneGraphNode cloneGraph(CloneGraphNode node) {
        Map<Integer,CloneGraphNode> map = new HashMap<>();
        return dfs(node,map);
    }
    private CloneGraphNode dfs(CloneGraphNode node, Map<Integer,CloneGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        } else {
            CloneGraphNode clone = new CloneGraphNode(node.val);
            map.put(node.val,clone);
            for (int i = 0; i < node.neighbors.size(); i++) {
                clone.neighbors.add(dfs(node.neighbors.get(i), map));
            }
            return clone;
        }
    }


}
