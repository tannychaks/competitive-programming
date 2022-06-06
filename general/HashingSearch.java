package general;

public class HashingSearch {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 0, 9, -1, 6, -5, -6, 10 };
        insert(nums, nums.length);
        int find = -5;
        System.out.println(search(find));
        find = 25;
        System.out.println(search(find));

    }

    private static int MAX = 1000;

    private static boolean[][] hashTable = new boolean[MAX + 1][2];

    private static void insert(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0)
                hashTable[nums[i]][0] = true;
            else
                hashTable[Math.abs(nums[i])][1] = true;
        }
    }

    /**
     * TC: O(1)
     * 
     * @param find
     * @return
     */
    private static boolean search(int find) {
        if (find >= 0)
            return (hashTable[find][0]);
        else {
            find = Math.abs(find);
            return hashTable[find][1];
        }
    }
}
