/*
    在任意时刻的都能给出数组的中位数

    堆排序实现
 */
public class MedianAtAnyTime {
    //大小根堆
    private static int[] small = new int[10];
    private static int[] large = new int[10];
    private static int largeSize = 0;
    private static int smallSize = 0;

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (largeSize == 0) {
                large[largeSize] = arr[i];
                largeSize++;
            } else if (arr[i] > large[0]) {
                //加到小根堆
                small[smallSize] = arr[i];
                heapInsertMin(arr,arr[i]);
                smallSize++;
            } else if (arr[i] < large[0]) {
                //加到大根堆
                large[largeSize] = arr[i];
                heapInsertMax(arr,arr[i]);
                largeSize++;
            }

            if ((largeSize - smallSize == 2)) {
                //把大根堆顶部给小根堆
                swap(large,0,largeSize - 1);
                largeSize--;
                heapfyLarge(large);
                heapInsertMin(small,large[largeSize]);
            } else if ((smallSize - largeSize) == 2) {
                swap(small,0,smallSize - 1);
                smallSize--;
                heapfySmall(small);
                heapInsertMax(large,small[smallSize]);
            }

        }


    }



    //将根部变换后重新形成堆结构
    public static void heapfyLarge(int[] arr) {
        int left = 2;
        int index = 0;
        while (left < largeSize) {
            int largest = left + 1 < largeSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapfySmall(int[] arr) {
        int left = 2;
        int index = 0;
        while (left < smallSize) {
            int smallest = left + 1 < smallSize && arr[left + 1] < arr[left] ? left + 1 : left;
            smallest = arr[smallest] < arr[index] ? smallest : index;
            if (smallest == index) {
                break;
            }
            swap(arr, smallest, index);
            index = smallest;
            left = index * 2 + 1;
        }
    }

    //插入时形成堆
    public static void heapInsertMax(int[] arr, int index) {
        int current = largeSize - 1;
        while (arr[current] > arr[(current-1)/2] && current >= 0) {
            swap(arr,current,(current-1)/2);
            current = (current-1)/2;
        }
    }

    public static void heapInsertMin(int[] arr, int index) {
        int current = smallSize - 1;
        while (arr[current] < arr[(current-1)/2] && current >= 0) {
            swap(arr,current,(current-1)/2);
            current = (current-1)/2;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        heapSort(arr);
    }

}
