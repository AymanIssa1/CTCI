package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class List_of_Depths_2 {

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        // Visit the root
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current;

            // Go to next level
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                // visit the children
                if (parent.left != null)
                    current.add(parent.left);
                if (parent.right != null)
                    current.add(parent.right);

            }
        }
        return result;
    }

}