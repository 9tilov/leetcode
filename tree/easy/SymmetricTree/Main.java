package tree.easy.SymmetricTree;

import tree.support.TreeNode;

public class Main {

    public static void main(String args[]) {
        SymmetricTree solution = new SymmetricTree();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        root.left = node2;
        root.right = node22;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node2.left = node3;
        node2.right = node4;
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        node22.left = node5;
        node22.right = node6;
        System.out.println(solution.isSymmetric(root));
    }
}
