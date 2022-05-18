package striverSDEsheet.day7;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println(trapPrefix(height));
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {

        int trappedWater = 0;
        int n = height.length;
        int l = 0, r = n - 1, leftMax = 0, rightMax = 0;

        while (l <= r) {

            if (height[l] <= height[r]) {
                if (height[l] >= leftMax)
                    leftMax = height[l];
                else
                    trappedWater += leftMax - height[l];
                l++;
            } else {
                if (height[r] >= rightMax)
                    rightMax = height[r];
                else
                    trappedWater += rightMax - height[r];
                r--;
            }
        }
        return trappedWater;
    }

    /**
     * TC: O(N*N)
     * SC: O(2N)
     * 
     * @param height
     * @return
     */
    private static int trapPrefix(int[] height) {
        int trappedWater = 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trappedWater;
    }
}
