/*
    反转单向和双向链表
    【题目】 分别实现反转单向链表和反转双向链表的函数。
    【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间 复杂度要求为O(1)
 */
public class ReverseList {

    //单向列表
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseSingleList(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printSingleList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }


    //双向列表
    public static class DoubleNode {
        private DoubleNode last;
        private DoubleNode next;
        private int value;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode last = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = last;
            head.last = next;
            last = head;
            head = next;
        }
        return last;
    }


    public static void printDoubleList(DoubleNode node) {
        DoubleNode end = null;

        while (node != null) {
            System.out.print(node.value + " ");
            end = node;
            node = node.next;
        }
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
     }







    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printSingleList(head1);
        head1 = reverseSingleList(head1);
        printSingleList(head1);

        System.out.println("--------------------");

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleList(head2);
        printDoubleList(reverseDoubleList(head2));
    }
}
