import java.util.Scanner;

class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void deleteFromBeginning() {
        if (head == null) {
            return;
        }

        head = head.next;
    }

    void deleteFromEnd() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        list.insertAtEnd(n1);
        list.insertAtFront(n2);

        list.deleteFromBeginning();

        list.deleteFromEnd();

    }
}
