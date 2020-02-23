/*
    汉诺塔问题 打印n层汉诺塔从最左边移动到最右边的全部过程
 */
public class Hanoi {

    public static void move(int level,int down, String left, String mid, String right) {
        if (level == 1) {
            System.out.println("Move" + down +"from" + left + "to" + right);
        } else {
            move(level - 1,down - 1,left,right,mid);
            move(1,down,left,mid,right);
            move(level - 1,down - 1,mid,left,right);
        }
    }

    public static void main(String[] args) {
        move(5,5,"左","中","右");
    }
}
