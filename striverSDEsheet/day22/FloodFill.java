package striverSDEsheet.day22;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;

        int[][] newImage = floodFill(image, sr, sc, color);
        for (int i = 0; i < newImage.length; i++) {
            for (int j = 0; j < newImage[0].length; j++) {
                System.out.print(newImage[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFillHelper(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private static void floodFillHelper(int[][] image, int i, int j, int srcColor, int newColor) {
        if (i >= 0 && j >= 0 && i < image.length && j < image[0].length && image[i][j] == srcColor
                && srcColor != newColor) {
            image[i][j] = newColor;
            floodFillHelper(image, i - 1, j, srcColor, newColor); // top
            floodFillHelper(image, i + 1, j, srcColor, newColor);// down
            floodFillHelper(image, i, j - 1, srcColor, newColor);// left
            floodFillHelper(image, i, j + 1, srcColor, newColor);// right
        }
    }

}
