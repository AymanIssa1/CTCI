package Trees_and_Graphs;

import java.util.ArrayList;

public class Validate_8ST {

    // Solution #1: In-Order Traversal and array
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


    // Solution #2: In-Order Traversal
    boolean checkBST2(TreeNode n) {
        Integer last_printed = null;
        return checkBST2(n, last_printed);
    }

    boolean checkBST2(TreeNode n, Integer last_printed) {
        if (n == null) return true;

        // Check / recurse left
        if (!checkBST2(n.left, last_printed)) return false;

        // Chect current
        if (last_printed != null && n.value <= last_printed)
            return false;

        last_printed = n.value;

        // Check / recurse right
        if (!checkBST2(n.right, last_printed)) return false;

        return true; // All good!
    }

    // Solution #3: The Min / Max Solution
    boolean checkBST3(TreeNode n) {
        return checkBST3(n, null, null);
    }

    boolean checkBST3(TreeNode n, Integer min, Integer max) {
        if (n == null)
            return true;

        if ((min != null && n.value <= min) || (max != null && n.value > max))
            return false;

        if (!checkBST3(n.left, min, n.value) || !checkBST3(n.right, n.value, max))
            return false;
        return true;
    }


}
