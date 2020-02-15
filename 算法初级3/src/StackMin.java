import java.util.Stack;

/*
    实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返 回栈中最小元素的操作。
 */
public class StackMin {
    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void pushNum(int num) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(num);
            } else if (this.getMin() > num) {
                this.stackMin.push(num);
            }

            this.stackData.push(num);
        }

        public int popNum() {
            if (this.stackData.isEmpty()) {
                throw new StackOverflowError("out");
            }

            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new StackOverflowError("out");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.pushNum(4);
        myStack.pushNum(5);
        myStack.pushNum(3);
        myStack.pushNum(2);
        myStack.pushNum(8);

        int min = myStack.getMin();
        System.out.println(min);
    }
}
