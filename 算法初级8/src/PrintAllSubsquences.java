import java.util.Arrays;

/*
    打印一个字符串的全部子序列，包括空字符串
 */
public class PrintAllSubsquences {

    public static void printAll(char[] chars, int i, String str) {
        if (i == chars.length) {
            System.out.println(str);
            return;
        }
        printAll(chars,i + 1,str);
        printAll(chars,i + 1,str + String.valueOf(chars[i]));
    }

    public static void main(String[] args) {
        String s = "liu";
        char[] chars = s.toCharArray();

        printAll(chars,0,"");
    }
}
