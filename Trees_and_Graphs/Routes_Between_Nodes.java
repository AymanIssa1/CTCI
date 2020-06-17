package Trees_and_Graphs;

public class Routes_Between_Nodes {

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

}


