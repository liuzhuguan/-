/*
    数组结构实现固定大小的栈, 队列
 */
public class ArrayToStackAndQueue {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int iniSize) {
            if (iniSize <= 0 ) {
                throw new IllegalArgumentException("This size is too small to create it");
            }

            this.arr = new Integer[iniSize];
            this.index = 0;
        }

        public Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[index - 1];
        }

        public void push(int num) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("out");
            }
            arr[index++] = num;
        }

        public int pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("out");
            }
            return arr[--index];
        }

    }


    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        public ArrayQueue(int iniSize) {
            if (iniSize <= 0 ) {
                throw new IllegalArgumentException("This size is too small to create it");
            }

            this.arr = new Integer[iniSize];
            this.size = 0;
            this.start = 0;
            this.end = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        public void push(int num) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("out");
            }
            size++;
            arr[end] = num;
            end = end == (arr.length - 1) ? 0 : (end + 1);
        }

        public int pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("out");
            }
            size--;
            int temp = start;
            start = start == (arr.length - 1) ? 0 : (start + 1);
            return arr[temp];
        }
    }

    public static void main(String[] args) {
        /*
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(8);
        int pop = arrayStack.pop();
        System.out.println(pop);
         */

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.push(1);
        arrayQueue.push(2);
        int pop = arrayQueue.pop();
        System.out.println(pop);
    }
}
