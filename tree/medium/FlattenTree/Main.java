package tree.medium.FlattenTree;

import tree.support.TreeNode;

public class Main {

    public static void main(String args[]) {
        FlattenTree solution = new FlattenTree();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;
        TreeNode node4 = new TreeNode(4);
        node2.right = node4;
        TreeNode node5 = new TreeNode(5);
        root.right = node5;
        TreeNode node6 = new TreeNode(6);
        node5.right = node6;

        solution.flatten(root);
    }
}
