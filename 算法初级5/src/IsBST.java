import java.util.Stack;

/*
    判断一棵树是否是搜索二叉树
 */
public class IsBST {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean BST(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            int pre = Integer.MIN_VALUE;

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    int help = head.value;
                    if (help > pre) {
                        pre = help;
                        head = head.right;
                    } else {
                        return false;
                    }
                }

            }
            return true;
        }
       return false;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        System.out.println(BST(head));
    }
}
