/*
    【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成 顺时针旋转90度的样子。
     【要求】 额外空间复杂度为O(1)。
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int leftX = 0;
        int leftY = 0;
        int rightX = matrix.length - 1;
        int rightY = matrix[0].length - 1;

        while (leftX < rightX) {
            rotateEdge(matrix,leftX++,leftY++,rightX--,rightY--);
        }

    }

    public static void rotateEdge(int[][] matrix, int leftX, int leftY, int rightX, int rightY) {
        int times = rightX - leftX;
        int temp = 0;

        for (int i = 0; i != times; i++) {
            temp = matrix[leftY][leftX + i];
            matrix[leftY][leftX + i] = matrix[rightY - i][leftX];
            matrix[rightY - i][leftX] = matrix[rightY][rightX - i];
            matrix[rightY][rightX - i] = matrix[leftY + i][rightX];
            matrix[leftY + i][rightX] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);

        System.out.println("-----------------");

        printMatrix(matrix);
    }
}
