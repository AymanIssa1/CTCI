package Trees_and_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_Search {
    void dfs_search(Node root) {
        if (root == null)
            return;
        System.out.print(root.name + " -> ");
        root.visited = true;
        for (Node n : root.children) {
            if (!n.visited)
                dfs_search(n);
        }

    }

    void bfs_search(Node root) {
        Queue<Node> queue = new LinkedList<>();
        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(root.name + " -> ");
            for (Node n : node.children) {
                n.visited = true;
                queue.add(n);
            }

        }
    }
}
