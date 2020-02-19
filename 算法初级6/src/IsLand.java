/*
     岛问题
        一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右 四个位置相连，
     如果有一片1连在一起，这个部分叫做一个岛，求一个 矩阵中有多少个岛？

 */
public class IsLand {

    public static int countLand(int[][] arr) {
        if (arr == null || arr[0] == null) {
            return 0;
        }
        int height = arr.length;
        int width = arr[0].length;
        int res = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (arr[i][j] == 1) {
                    res++;
                    infect(arr,i,j,height,width);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] arr, int i, int j, int height, int width) {
        if (i >= height || j >= width || i < 0 || j < 0 || arr[i][j] != 1) {
            return;
        }

        arr[i][j] = 2;
        infect(arr,i + 1, j, height, width);
        infect(arr, i, j + 1, height, width);
        infect(arr, i - 1, j, height, width);
        infect(arr, i, j - 1, height, width);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countLand(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countLand(m2));
    }
}
