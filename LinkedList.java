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

    void insertAtMiddle(int data, int position) {

        if (position == 1) {
            insertAtFront(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
 
    void deleteFromBeginning() { 
        if (head == null) { 
            return; 
        } 
 
        head = head.next; 
    } 

    void deleteAtMiddle(int position) {

        if (head == null) {
            return;
        }

        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
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

        list.insertAtMiddle(30, 2);

        list.deleteFromBeginning(); 

        list.deleteAtMiddle(2);
 
        list.deleteFromEnd(); 

        
    } 
}
