package striverSDEsheet.day21;

public class FloorBST {
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

        int x = 8;
        int ans = floorInBST(root, x);
        System.out.println(ans);
    }

    private static int floorInBST(TreeNode root, int x) {
        int floor = -1;
        while (root != null) {
            if (root.val == x) {
                floor = x;
                return floor;
            }
            if (root.val < x) {
                floor = root.val;
                root = root.right;
            } else
                root = root.left;
        }

        return floor;
    }

}
