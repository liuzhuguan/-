/*
    在二叉树中找到一个节点的后继节点
 */
public class SuccessorNode {

    public static class Node {
        private Node left;
        private Node right;
        private Node parent;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessor(Node head) {
        if (head == null) {
            return head;
        }

        if (head.right != null) {
            Node leftMost = findLeftMost(head.right);
            return leftMost;
        } else {
            Node parent = head.parent;
            while (parent != null && parent.left != head) {
                head = parent;
                parent = head.parent;
            }
            return parent;
        }
    }


    public static Node findLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessor(test).value);
    }
}
