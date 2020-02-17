import java.util.Stack;

/*
    实现二叉树的先序、中序、后序遍历，包括递归方式和非递归 方式
 */
public class PreInPosTraversal {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    /*
        先根遍历
     */
    //递归形式
    public static void preRoot(Node head) {
        if (head == null) {
            return;
        }

        System.out.print(head.value + " ");
        preRoot(head.left);
        preRoot(head.right);
    }

    //非递归形式
    public static void preRoot2(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }

    }


    /*
        中根遍历
     */
    //递归形式
    public static void inRoot(Node head) {
        if (head == null) {
            return;
        }

        inRoot(head.left);
        System.out.print(head.value + " ");
        inRoot(head.right);
    }

    //非递归形式
    public static void inRoot2(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }

            }
        }
    }


    /*
        后根遍历
     */
    //递归形式
    public static void posRoot(Node head) {
        if (head == null) {
            return;
        }

        posRoot(head.left);
        posRoot(head.right);
        System.out.print(head.value + " ");
    }

    //非递归形式
    public static void posRoot2(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.push(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                help.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }

            while (!help.isEmpty()) {
                System.out.print(help.pop().value + " ");
            }
        }
    }



    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        preRoot(head);
        System.out.println();
        inRoot(head);
        System.out.println();
        posRoot(head);
        System.out.println();
        preRoot2(head);
        System.out.println();
        inRoot2(head);
        System.out.println();
        posRoot2(head);
    }
}
