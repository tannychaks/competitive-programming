package striverSDEsheet.day17;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {
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

        int ans = widthOfBinaryTree(root);
        System.out.println(ans);
    }

    static class Pair {
        TreeNode node;
        int id;

        Pair() {
        };

        Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    private static int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().id;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int currId = q.peek().id - min;
                TreeNode node = q.peek().node;
                q.poll();
                if (i == 0)
                    first = currId;

                if (i == size - 1)
                    last = currId;

                if (node.left != null)
                    q.offer(new Pair(node.left, currId * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, currId * 2 + 2));
            }

            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
