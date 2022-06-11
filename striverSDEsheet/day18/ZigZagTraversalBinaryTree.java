package striverSDEsheet.day18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversalBinaryTree {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = zigzagLevelOrder(root);

        ans.stream().forEach(list -> {
            list.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToright = true;
        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> ds = new ArrayList<>(levelNum);
            for (int i = 0; i < levelNum; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);
                if (leftToright)
                    ds.add(q.poll().val);
                else
                    ds.add(0, q.poll().val);
            }
            // end of level
            leftToright = !leftToright;
            ans.add(ds);
        }

        return ans;
    }

}
