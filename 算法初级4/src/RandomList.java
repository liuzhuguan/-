import java.util.HashMap;

/*
    复制含有随机指针节点的链表
    【题目】 一种特殊的链表节点类描述如下：
    public class Node { public int value; public Node next; public Node rand; public Node(int data) { this.value = data; } }
    Node类中的value是节点值，next指针和正常单链表中next指针的意义 一 样，
    都指向下一个节点，rand指针是Node类中新增的指针，这个指 针可 能指向链表中的任意一个节点，
    也可能指向null。 给定一个由 Node节点类型组成的无环单链表的头节点head，请
    实现一个 函数完成 这个链表中所有结构的复制，并返回复制的新链表的头节点。
    进阶： 不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N) 内完成原问题要实现的函数。
 */
public class RandomList {

    public static class Node {
        private Node rand;
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node copyList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node current = head;

        while (current != null) {
            map.put(current,new Node(current.value));
            current = current.next;
        }

        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).rand = map.get(current.rand);
            current = current.next;
         }

        return map.get(head);
    }

    public static void printList(Node node) {
        Node node1 = node;
        while (node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next;
        }

        System.out.println();
        System.out.println("-----");

        Node node2 = node;
        while (node2 != null) {
            System.out.print(node2.rand == null ? "-" : node2.rand.value + " ");
            node2 = node2.next;
        }
        System.out.println();
        System.out.println("-----");
    }

    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // copy node and link to every node
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // set copy node rand
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node head = null;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        Node node = copyList(head);

        printList(node);


    }
}
