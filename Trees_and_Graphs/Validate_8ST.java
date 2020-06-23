package Trees_and_Graphs;

import java.util.ArrayList;

public class Validate_8ST {

    // Solution #1: In-Order Traversal
    // but it would only work if we assume the the tree cannot have duplicates values
    // as it doesn't recognize if the root and the right node have the same value
    void copyBST(TreeNode root, ArrayList<Integer> array) {
        if (root == null) return;
        copyBST(root.left, array);
        array.add(root.value);
        copyBST(root.right, array);
    }

    boolean checkBST(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<>();
        copyBST(root, array);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) <= array.get(i - 1))
                return false;
        }
        return true;
    }

}
