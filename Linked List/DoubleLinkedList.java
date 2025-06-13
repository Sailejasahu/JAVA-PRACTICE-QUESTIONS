public class DoubleLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev=null;

        }
    }
    public static Node insertatbegin(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        return newNode;
    }
    public static Node insertatend(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current; 
        return head;
    }
    public static Node insertNthposition(Node head, int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            return newNode;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return head;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        return head;
    }
    public static void display(Node head) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head = null;
        head = insertatbegin(head, 10);
        head = insertatend(head, 20);
        head = insertatend(head, 30);
        head = insertNthposition(head, 25, 2);
        display(head);
    }
}
