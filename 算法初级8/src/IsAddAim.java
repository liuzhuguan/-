/*
        给你一个数组arr，和一个整数aim。如果可以任意选择arr中的 数字，
    能不能累加得到aim，返回true或者false
 */
public class IsAddAim {

    public static boolean isSum1(int[] arr, int aim) {
        if (arr == null) {
            return false;
        }
        return process1(arr, aim, 0, 0);
    }

    public static boolean process1(int[] arr, int aim, int i, int sum) {
        if (i == arr.length) {
            return aim == sum;
        }

        return process1(arr, aim, i + 1,sum) || process1(arr, aim, i + 1, sum + arr[i]);
    }

    public static boolean money2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int arr[] = {1,4,6,8,34};
        int aim = 14;

        boolean sum1 = isSum1(arr, aim);
        System.out.println(sum1);
        boolean b = money2(arr, aim);
        System.out.println(b);
    }
}
