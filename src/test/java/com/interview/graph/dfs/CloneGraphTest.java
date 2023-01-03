package com.interview.graph.dfs;

import com.interview.graph.dfs.medium.CloneGraph;
import com.interview.graph.others.CloneGraphNode;
import org.junit.Test;

import java.util.ArrayList;

public class CloneGraphTest {

    CloneGraphNode node1 = new CloneGraphNode(1);
    CloneGraphNode node2 = new CloneGraphNode(2);
    CloneGraphNode node3 = new CloneGraphNode(3);
    CloneGraphNode node4 = new CloneGraphNode(4);

    CloneGraph cloneGraphObject = new CloneGraph();

    @Test
    public void cloneGraphTestOfNode1() {

        ArrayList<CloneGraphNode> _neighborsOf1 = new ArrayList<CloneGraphNode>();
        _neighborsOf1.add(node2);
        _neighborsOf1.add(node4);

        CloneGraphNode node = new CloneGraphNode(1, _neighborsOf1);
        CloneGraphNode neighboursObj = cloneGraphObject.cloneGraph(node);
        printNeighbours(neighboursObj);

    }

    @Test
    public void cloneGraphTestOfNode2() {
        ArrayList<CloneGraphNode> _neighborsOf2 = new ArrayList<CloneGraphNode>();
        _neighborsOf2.add(node1);
        _neighborsOf2.add(node3);

        CloneGraphNode node = new CloneGraphNode(2, _neighborsOf2);
        CloneGraphNode neighboursObj = cloneGraphObject.cloneGraph(node);
        printNeighbours(neighboursObj);


    }


    public void printNeighbours(CloneGraphNode node) {
        System.out.print("Neighbors of node :" + node.val
                + " are  :"
                + node.neighbors.get(0).val +","+ node.neighbors.get(1).val);
    }
}
