/*
    求n!的结果   递归求解
 */
public class N {

    public static int factorial(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }


    public static void main(String[] args) {
        int a = factorial(5);
        System.out.println(a);

        int b = factorial(0);
        System.out.println(b);
    }
}
