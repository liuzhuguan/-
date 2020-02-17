import java.util.LinkedList;
import java.util.Queue;

/*
    判断一棵树是否是完全二叉树
 */
public class IsCBT {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean CBT(Node head) {
        if (head == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        queue.offer(head);

        while (!queue.isEmpty()) {
            head = queue.poll();

            if ((head.right != null && head.left == null) || (leaf && (head.left != null || head.right != null))) {
                return false;
            }
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
            if ((head.left == null && head.right == null) || (head.left != null && head.right == null )) {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        boolean b = CBT(head);
        System.out.println(b);


    }

}
