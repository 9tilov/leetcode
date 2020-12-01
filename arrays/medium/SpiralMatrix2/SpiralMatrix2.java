package arrays.medium.SpiralMatrix2;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int topRow = 0;
        int bottomRow = n - 1;
        int rightColumn = n - 1;
        int leftColumn = 0;
        int[][] result = new int[n][n];
        int counter = 1;
        while (counter <= n * n) {
            for (int i = leftColumn; i <= rightColumn; ++i) {
                result[topRow][i] = counter;
                ++counter;
            }
            topRow++;
            for (int i = topRow; i <= bottomRow; ++i) {
                result[i][rightColumn] = counter;
                ++counter;
            }
            rightColumn--;
            for (int i = rightColumn; i >= leftColumn; --i) {
                result[bottomRow][i] = counter;
                ++counter;
            }
            bottomRow--;
            for (int i = bottomRow; i >= topRow; --i) {
                result[i][leftColumn] = counter++;
            }
            leftColumn++;

        }
        return result;
    }
}
