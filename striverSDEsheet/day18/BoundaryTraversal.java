package striverSDEsheet.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoundaryTraversal {
    static class Node {
        int val;
        Node left;
        Node right;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        List<Integer> ans = printBoundary(root);
        ans.stream().forEach(val -> System.out.print(val + " "));
    }

    private static List<Integer> printBoundary(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (!isLeaf(root))
            ans.add(root.val);
        addLeftBoundary(root.left, ans);
        addLeaves(root, ans);
        addRightBoundary(root.right, ans);
        return ans;
    }

    private static void addRightBoundary(Node node, List<Integer> ans) {
        List<Integer> ds = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node))
                ds.add(node.val);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        IntStream.range(0, ds.size()).map(i -> ds.size() - i - 1).map(ds::get).forEach(ans::add);
    }

    private static void addLeaves(Node root, List<Integer> ans) {
        if (root.left != null)
            addLeaves(root.left, ans);

        if (isLeaf(root)) {
            ans.add(root.val);
            return;
        }

        else if (root.right != null)
            addLeaves(root.right, ans);
    }

    private static void addLeftBoundary(Node node, List<Integer> ans) {
        while (node != null) {
            if (!isLeaf(node))
                ans.add(node.val);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    private static boolean isLeaf(Node node) {
        return (node.left == null) && (node.right == null);
    }

}
