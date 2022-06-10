package striverSDEsheet.day17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
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

    static class Tuple {
        TreeNode node;
        int vertical;
        int level;

        Tuple() {
        }

        Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = verticalTraversal(root);
        ans.stream().forEach(list -> {
            list.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    private static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();

            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if (!mp.containsKey(vertical))
                mp.put(vertical, new TreeMap<>());

            if (!mp.get(vertical).containsKey(level))
                mp.get(vertical).put(level, new PriorityQueue<>());

            mp.get(vertical).get(level).offer(node.val);

            if (node.left != null)
                q.offer(new Tuple(node.left, vertical - 1, level + 1));

            if (node.right != null)
                q.offer(new Tuple(node.right, vertical + 1, level + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> map : mp.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : map.values()) {
                while (!nodes.isEmpty())
                    ans.get(ans.size() - 1).add(nodes.poll());
            }
        }
        return ans;
    }
}
