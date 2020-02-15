/*
    桶排序---计数排序
 */

public class BucketSort {

    public static void bucket(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //数组最大的数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }

        //创建一个大1数组
        int[] help = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                arr[j++] = i;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,9,7,5,3,5};

        bucket(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}
