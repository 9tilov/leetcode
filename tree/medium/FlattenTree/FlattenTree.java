package tree.medium.flattenTree;

import tree.support.TreeNode;

public class FlattenTree {

    private TreeNode tmp;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = tmp;
        root.left = null;
        tmp = root;
    }
}
