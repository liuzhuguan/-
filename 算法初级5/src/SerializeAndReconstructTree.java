import java.util.LinkedList;
import java.util.Queue;

/*
    二叉树的序列化和反序列化
 */
public class SerializeAndReconstructTree {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static String serialize(Node head) {
        if (head == null) {
            return "#!";
        }

        String res = head.value + "!";
        res = res + serialize(head.left);
        res = res + serialize(head.right);

        return res;
    }

    public static Node reSerialize(String str) {
        String[] strings = str.split("!");
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < strings.length; i++) {
            queue.offer(strings[i]);
        }
        Node head = again(queue);

        return head;
    }

    public static Node again(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = again(queue);
        head.right = again(queue);

        return head;
    }

    public static void main(String[] args) {
        Node head = null;

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);

        String s = serialize(head);
        System.out.println(s);

        Node node = reSerialize(s);
        System.out.println(node.value);
    }
}
