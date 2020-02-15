/*
    给定一个数组，求如果排序之后，相邻两数的最大差值，
    要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 */
public class MaxGap {

    public static int getGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        //获取当前数组最大最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
            min = min < arr[i] ? min : arr[i];
        }
        if (min == max) {
            return 0;
        }

        int len = arr.length + 1;
        int[] maxs = new int[len];
        int[] mins = new int[len];
        boolean[] hasNum = new boolean[len];
        int bid = 0;

        for (int i = 0; i < arr.length; i++) {
            bid = bucket(arr[i],max,min,len-1);
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],arr[i]) : arr[i];
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],arr[i]) : arr[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int i = 1;
        int lastMax = maxs[0];
        for (; i < len; i++) {
            if (hasNum[i]) {
                res = res > (mins[i] - lastMax) ? res : (mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    public static int bucket(long num, long max, long min, long len) {
        return  (int) ((num - min) * len/(max - min));
    }


    public static void main(String[] args) {
        int[] arr = {1,13,32,15,66,24,99};

        int gap = getGap(arr);
        System.out.println(gap);
    }
}
