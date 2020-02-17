/*
    判断一棵二叉树是否是平衡二叉树
 */
public class IsBalanceTree {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnData {
        private int h; // 树高度
        private boolean result;

        public ReturnData(int h, boolean result) {
            this.h = h;
            this.result = result;
        }
    }

    public static boolean isBalance(Node head) {
        return process(head).result;
    }

    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(0,true);
        }
        ReturnData leftData = process(head.left);
        if (!leftData.result) {
            return new ReturnData(0,false);
        }
        ReturnData rightData = process(head.right);
        if (!rightData.result) {
            return new ReturnData(0,false);
        }
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnData(0,false);
        }

        return new ReturnData(Math.max(leftData.h, rightData.h), true);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));
    }
}
