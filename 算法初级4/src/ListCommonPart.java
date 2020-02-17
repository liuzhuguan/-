/*
    打印两个有序链表的公共部分
    【题目】 给定两个有序链表的头指针head1和head2，打印两个 链表的公共部分。
 */
public class ListCommonPart {
    //单向列表
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printCommon(Node node1, Node node2) {
        System.out.println("Common Part :");
        while (node1 != null && node2 != null) {
            if (node1.value > node2.value) {
                node2 = node2.next;
            } else if (node1.value < node2.value) {
                node1 = node1.next;
            } else {
                System.out.print(node1.value + " ");
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }

    public static void printSingleList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printSingleList(node1);
        printSingleList(node2);
        printCommon(node1, node2);

    }
}
