package striverSDEsheet.day20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchKeyBST {
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

        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;
        TreeNode ans = searchBST(root, val);

        printNode(ans);
    }

    private static void printNode(TreeNode root) {
        List<List<Integer>> ans = levelOrder(root);
        ans.stream().forEach(list -> {
            list.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }

    private static TreeNode searchBST(TreeNode root, int val) {

        while (root != null && root.val != val)
            root = val < root.val ? root.left : root.right;
        return root;
    }
}
