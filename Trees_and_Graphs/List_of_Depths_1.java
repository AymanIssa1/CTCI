package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class List_of_Depths_1 {

    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;// base case

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {  // Level not contained in list
            list = new LinkedList<TreeNode>();
            /* Levels are always traversed in order. So, if this is the first time we've
             * visited level i, we must have seen levels 0 through i - 1. We can
             * therefore safely add the level at the end. */
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

}
