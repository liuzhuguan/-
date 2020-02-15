/*
    给定一个数组arr，和一个数num，请把小于等于num的数放在数 组的左边，大于num的数放在数组的右边。

    要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class GroupNumber {

    public static int[] groupArray(int[] arr, int num) {
        int x = -1;
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                help[i] = arr[i];
                swap(help,++x,i);
            } else {
                help[i] = arr[i];
            }
        }

        for (int j = 0; j < help.length; j++) {
            arr[j] = help[j];
        }

        return arr;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,5,7,6,2};
        int[] array = groupArray(arr, 4);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
