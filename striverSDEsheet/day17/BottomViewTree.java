package striverSDEsheet.day17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewTree {
    static class TreeNode {
        int val;
        int hd;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            hd = Integer.MAX_VALUE;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;

            hd = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<Integer> ans = bottomView(root);
        ans.stream().forEach(val -> System.out.print(val + " "));
    }

    private static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Map<Integer, Integer> mp = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        root.hd = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int hd = node.hd;
            mp.put(hd, node.val);
            if (node.left != null) {
                node.left.hd = hd - 1;
                q.offer(node.left);
            }
            if (node.right != null) {
                node.right.hd = hd + 1;
                q.offer(node.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            ans.add(entry.getValue());
        return ans;
    }

}
