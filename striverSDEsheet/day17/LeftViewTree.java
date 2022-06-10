package striverSDEsheet.day17;

import java.util.ArrayList;
import java.util.List;

public class LeftViewTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<Integer> ans = leftView(root);
        ans.stream().forEach(val -> System.out.print(val + " "));
    }

    private static List<Integer> leftView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        leftView(root, 0, ans);
        return ans;
    }

    private static void leftView(TreeNode root, int level, List<Integer> ans) {
        if (root == null)
            return;
        if (level == ans.size())
            ans.add(root.val);
        leftView(root.left, level + 1, ans);
        leftView(root.right, level + 1, ans);

    }
}
