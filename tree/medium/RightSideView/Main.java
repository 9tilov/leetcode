package tree.medium.RightSideView;

import tree.support.TreeNode;

public class Main {

    public static void main(String args[]) {
        RightSideView solution = new RightSideView();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        TreeNode node3 = new TreeNode(3);
        root.right = node3;
        TreeNode node4 = new TreeNode(4);
        node3.right = node4;
        TreeNode node5 = new TreeNode(5);
        node2.right = node5;

        solution.rightSideView(root);
    }
}
