/*
    问题二（荷兰国旗问题）

    给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放在数组的中间，大于num的数放在数组的 右边。
 */

public class Netherland {

    public static int[] partition(int[] arr, int l, int r, int num) {
        int less = l - 1;
        int more = r + 1;
        int index = l;

        while (index < more) {
            if (arr[index] < num) {
                swap(arr,++less,index++);
            } else if (arr[index] > num) {
                swap(arr,--more,index);
            } else {
                index++;
            }
        }

        return new int[] {less + 1, more - 1};
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,2,4,5,6,8};

        int[] partition = partition(arr, 0, arr.length - 1, 4);
        for (int i = 0; i < partition.length; i++) {
            System.out.println(partition[i]);
        }
    }
}
