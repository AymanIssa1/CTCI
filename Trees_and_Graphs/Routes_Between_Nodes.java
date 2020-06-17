package Trees_and_Graphs;

import java.util.LinkedList;

public class Routes_Between_Nodes {

    boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        // operates as Queue
        LinkedList<Node> q = new LinkedList<>();

        for (Node u : g.nodes) {
            u.state = State.Unvisited;
        }

        start.state = State.Visited;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.children) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    enum State {Unvisited, Visited, Visiting}

    static class Graph {
        public Node[] nodes;
    }

    static class Node {
        public String name;
        public Node[] children;
        public State state;

    }
}


