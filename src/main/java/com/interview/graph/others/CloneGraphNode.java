package com.interview.graph.others;

import java.util.ArrayList;
import java.util.List;

public class CloneGraphNode {


    public int val;
    public List<CloneGraphNode> neighbors;


    public CloneGraphNode() {
        val = 0;
        neighbors = new ArrayList<CloneGraphNode>();
    }

    public CloneGraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<CloneGraphNode>();
    }

    public CloneGraphNode(int _val, ArrayList<CloneGraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}