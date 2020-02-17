/*
    转圈打印矩阵   【要求】 额外空间复杂度为O(1)。
 */

public class PrintMatrix {

    public static void printRotate(int[][] matrix) {
        int leftX = 0;
        int leftY = 0;
        int rightX = matrix.length - 1;
        int rightY = matrix[0].length - 1;

        while (leftX <= rightX && leftY <= rightY) {
            printEdge(matrix,leftX++,leftY++,rightX--,rightY--);
        }
    }

    public static void printEdge(int[][] matrix, int leftX, int leftY, int rightX, int rightY) {
        if (leftX == rightX) {
            for (int i = leftY; i <= rightY; i++) {
                System.out.print(matrix[i][leftX] + " ");
            }
        } else if (leftY == rightY) {
            for (int i = leftX; i <= rightX; i++) {
                System.out.print(matrix[leftY][i] + " ");
            }
        } else {
            int x = leftX;
            int y = leftY;
            while (x != rightX) {
                System.out.print(matrix[leftY][x] + " ");
                x++;
            }
            while (y != rightY) {
                System.out.print(matrix[y][rightX] + " ");
                y++;
            }
            while (x != leftX) {
                System.out.print(matrix[rightY][x] + " ");
                x--;
            }
            while (y != leftY) {
                System.out.print(matrix[y][leftX] + " ");
                y--;
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printRotate(matrix);

    }


}
