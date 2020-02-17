/*
    已知一棵完全二叉树，求其节点的个数
     要求：时间复杂度低于O(N)，N为这棵树的节点个数
 */
public class CompleteTreeNodeNumber {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int completeTree(Node head) {
        if (head == null) {
            return 0;
        }

        return bs(head,1, mostLeftDeep(head,1));
    }

    public static int bs(Node head, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftDeep(head.right,level + 1) == h) {
            return  (1 << (h - level)) + bs(head.right,level + 1,h);
        } else {
            return (1 << (h - level - 1)) + bs(head.left,level + 1,h);
        }
    }

    public static int mostLeftDeep(Node head, int level) {
        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(completeTree(head));
    }
}
