package Trees_and_Graphs;

public class Check_Tree_balanced {

    // 1st approach (Not optimized as we keep calling getHeight)
    int getHeight(TreeNode root) {
        if (root == null) return -1; // base case
        return Math.max(getHeight(root.left), getHeight(root.right));
    }

    boolean isBalanced(TreeNode root) {
        if (root == null) return true; // Base case

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 2nd approach
    int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1)
            return Integer.MIN_VALUE; // Found error -> Pass it back
        return Math.max(leftHeight, rightHeight) + 1;
    }

    boolean isBalanced2(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

}
