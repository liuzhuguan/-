/*
        给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的 重量，
    v[i]表示第i件商品的价值。 再给定一个整数bag，要求 你挑选商品
    的重量加起来一定不能超 过bag，返回满足这个条件 下，你能获得的最大价值。
 */
public class KnapSack {

    public static int maxValue1(int[] w, int[] v, int bag) {
        return process1(w, v, 0, 0,bag);
    }

    public static int process1(int[] w, int[] v, int indexW, int currentW, int bag) {
        if (currentW > bag) {
            return 0;
        }
        if (indexW == w.length) {
            return 0;
        }
        return Math.max(process1(w, v, indexW + 1, currentW, bag),
                v[indexW] + process1(w, v, indexW + 1, currentW + w[indexW], bag));
    }


    public static int maxValue2(int[] w, int[] v, int bag) {
        int[][] dp = new int[w.length + 1][bag + 1];
        for (int i = w.length - 1; i >= 0 ; i--) {
            for (int j = bag; j >= 0 ; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + w[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i + 1][j + w[i]]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] w = {3, 2, 4, 7 };
        int[] v = {5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue2(w, v, bag));
    }
}
