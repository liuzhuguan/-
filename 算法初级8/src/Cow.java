/*
    母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只 母牛，假设不会死。求N年后，母牛的数量。
 */
public class Cow {

    public static int countCow(int year) {
        if (year == 1 || year == 2 || year == 3) {
            return year;
        }
        return countCow(year - 1) + countCow(year - 3);
    }

    public static void main(String[] args) {
        int i = countCow(5);
        System.out.println(i);
    }
}
