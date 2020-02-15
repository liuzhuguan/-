import org.omg.PortableInterceptor.INACTIVE;

import javax.naming.LinkException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    队列与栈互相实现
 */
public class QueueAndStackConvert {

    public static class StackToQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public StackToQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int num) {
            stackPush.push(num);
        }

        public int pop() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new StackOverflowError("out");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }

            return stackPop.pop();
        }

        public int peek() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new StackOverflowError("out");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }

            return stackPop.peek();
        }
    }


    public static class QueueToStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public QueueToStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int num) {
            queue.add(num);
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("out");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }

            int res = queue.poll();
            swap(queue,help);
            return res;
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("out");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }

            int res = queue.poll();
            swap(queue,help);
            return res;
        }


        public static void swap(Queue<Integer> queue1,Queue<Integer> queue2) {
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 =temp;
        }

    }

    public static void main(String[] args) {
        /*
        StackToQueue stackToQueue = new StackToQueue();

        stackToQueue.push(1);
        stackToQueue.push(3);
        stackToQueue.push(5);
        stackToQueue.push(2);

        int pop = stackToQueue.pop();
        System.out.println(pop);
         */
        QueueToStack queueToStack = new QueueToStack();

        queueToStack.push(1);
        queueToStack.push(3);
        queueToStack.push(4);
        queueToStack.push(2);

        int pop = queueToStack.pop();
        System.out.println(pop);
    }
}
