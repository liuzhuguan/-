/*
         给你一个二维数组，二维数组中的每个数都是正数，要求从左上 角走到右下角，
    每一步只能向右或者向下。沿途经过的数字要累 加起来。返回最小的路径和
 */
public class MinPath {

    /*
        暴力递归
     */
    public static int minPath1(int[][] arr) {
        if (arr == null) {
            return 0;
        }
        return process1(arr,0, 0);
    }

    public static int process1(int[][] arr, int i, int j) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return arr[i][j];
        }
        if (i == arr.length - 1 && j != arr[0].length - 1) {
            return arr[i][j] + process1(arr,i,j + 1);
        }
        if (i != arr.length - 1 && j == arr[0].length - 1) {
            return arr[i][j] + process1(arr,i + 1,j);
        }

        return arr[i][j] + Math.min(process1(arr,i + 1,j),process1(arr,i,j + 1));
    }

    /*
        动态规划
     */
    public static int minPath2(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }

        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j]) + arr[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
