package tree.medium.RightSideView;

import tree.support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = q.removeLast();
                if (i == 0) {
                    res.add(tmp.val);
                }
                if (tmp.right != null) {
                    q.addFirst(tmp.right);
                }
                if (tmp.left != null) {
                    q.addFirst(tmp.left);
                }
            }
        }
        return res;
    }

    private List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {
        traverse(root, 0);
        return result;
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) return;
        if (level == result.size()) {
            result.add(root.val);
        }
        traverse(root.right, level + 1);
        traverse(root.left, level + 1);
    }
}
